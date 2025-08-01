package org.example.data.impl;

import org.example.data.OrderRepo;
import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.data.mappers.*;
import org.example.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepoImpl implements OrderRepo {

    private final JdbcTemplate jdbcTemplate;
    private final OrderWithServerMapper orderWithServerMapper;
    private final OrderItemMapper orderItemMapper;
    private final PaymentMapper paymentMapper;
    private final AllOrdersMapper allOrdersMapper;

    public OrderRepoImpl (@Autowired JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.orderWithServerMapper = new OrderWithServerMapper();
        this.orderItemMapper = new OrderItemMapper();
        this.paymentMapper = new PaymentMapper();
        this.allOrdersMapper = new AllOrdersMapper();
    }

    @Override
    public Order getOrderById(int id) throws RecordNotFoundException, InternalErrorException {
        try {
            return jdbcTemplate.execute((Connection conn) -> {

                try (CallableStatement stmt = conn.prepareCall("{call GetOrderById(?)}")) {
                    stmt.setInt(1, id);

                    boolean hasResults = stmt.execute();

                    Order order = null;
                    List<OrderItem> orderItems = new ArrayList<>();
                    List<Payment> payments = new ArrayList<>();

                    int resultSetNumber = 1;

                    while (hasResults) {
                        try (ResultSet resultSet = stmt.getResultSet()) {

                            if (resultSetNumber == 1) {

                                if (resultSet.next()) {
                                    order = orderWithServerMapper.mapRow(resultSet, 1);
                                } else {
                                    throw new RecordNotFoundException();
                                }

                            } else if (resultSetNumber == 2) {
                                int rowNum = 1;
                                while (resultSet.next()) {
                                    OrderItem oi = orderItemMapper.mapRow(resultSet, rowNum++);
                                    orderItems.add(oi);
                                }

                            } else if (resultSetNumber == 3) {
                                int rowNum = 1;
                                while (resultSet.next()) {
                                    Payment payment = paymentMapper.mapRow(resultSet, rowNum++);
                                    payments.add(payment);
                                }
                            }
                        }
                        resultSetNumber++;
                        hasResults = stmt.getMoreResults();
                    }

                    if (order == null) {
                        throw new RecordNotFoundException();
                    }

                    order.setItems(orderItems);
                    order.setPayments(payments);

                    return order;

                } catch (RecordNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (SQLException e) {
                    throw new RuntimeException(new InternalErrorException(e));
                }
            });

        } catch (DataAccessException e) {
            throw new InternalErrorException();
        }
    }

    @Override
    public List<Order> getAllOrders() throws InternalErrorException, RecordNotFoundException {
        String sql = """
                SELECT
                	o.OrderID,
                    o.OrderDate,
                    s.FirstName,
                    s.LastName,
                    o.Total
                FROM `Order` AS o
                INNER JOIN `Server` AS s ON o.ServerID = s.ServerID
                ORDER BY o.OrderID;
                """;

        try {
            List<Order> orders = jdbcTemplate.query(sql, allOrdersMapper);

            if (orders.isEmpty()) {
                throw new RecordNotFoundException();
            }
            return orders;

        }  catch (DataAccessException e) {
            throw new InternalErrorException();
        }
    }

    @Override
    public Order addOrder(Order order) throws InternalErrorException {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }

        try {
            return jdbcTemplate.execute((Connection conn) -> {
                try {
                    conn.setAutoCommit(false);

                    int orderID = callAddOrderProcedure(conn, order);
                    order.setOrderID(orderID);

                    if (order.getItems() != null && !order.getItems().isEmpty()) {
                        callAddOrderItems(conn, orderID, order.getItems());
                    }

                    if (order.getPayments() != null && !order.getPayments().isEmpty()) {
                        callAddPayment(conn, orderID, order.getPayments());
                    }

                    conn.commit();

                    return getOrderById(orderID);

                } catch (Exception e) {
                    // Rollback on any error
                    try {
                        conn.rollback();
                    } catch (SQLException rollbackEx) {
                        // Log rollback failure if needed
                    }
                    throw new RuntimeException(new InternalErrorException(e));
                } finally {
                    try {
                        conn.setAutoCommit(true);
                    } catch (SQLException e) {
                        // Log if needed
                    }
                }
            });

        } catch (RuntimeException e) {
            if (e.getCause() instanceof InternalErrorException) {
                throw (InternalErrorException) e.getCause();
            } else {
                throw new InternalErrorException(e);
            }
        }
    }

    private int callAddOrderProcedure(Connection conn, Order order) throws SQLException {
        try (CallableStatement stmt = conn.prepareCall("{call AddOrder(?, ?, ?, ?, ?, ?, ?)}")) {
            // Set input parameters
            stmt.setInt(1, order.getServerID());
            stmt.setTimestamp(2, java.sql.Timestamp.valueOf(order.getOrderDate()));
            stmt.setBigDecimal(3, order.getSubTotal());
            stmt.setBigDecimal(4, order.getTax());
            stmt.setBigDecimal(5, order.getTip());
            stmt.setBigDecimal(6, order.getTotal());

            stmt.registerOutParameter(7, java.sql.Types.INTEGER);

            // Execute the procedure
            boolean hasResults = stmt.execute();

            // Get the output parameter
            int orderID = stmt.getInt(7);

            // Debug: Check if the parameter was null
            boolean wasNull = stmt.wasNull();

            if (orderID <= 0 || wasNull) {
                throw new SQLException("Failed to generate order ID from stored procedure. OrderID: " + orderID + ", wasNull: " + wasNull);
            }
            return orderID;
        }
    }

    private void callAddOrderItems(Connection conn, int orderID, List<OrderItem> items) throws SQLException {
        try (CallableStatement stmt = conn.prepareCall("{call AddOrderItem(?, ?, ?, ?)}")) {
            for (OrderItem item : items) {
                stmt.setInt(1, orderID);
                stmt.setInt(2, item.getItemID());
                stmt.setInt(3, item.getQuantity());
                stmt.setBigDecimal(4, item.getPrice());

                stmt.execute();
            }
        }
    }

    private void callAddPayment(Connection conn, int orderID, List<Payment> payments) throws SQLException {
        try (CallableStatement stmt = conn.prepareCall("{call AddPayment(?, ?, ?)}")) {
            for (Payment payment : payments) {
                stmt.setInt(1, payment.getPaymentTypeID());
                stmt.setInt(2, orderID);
                stmt.setBigDecimal(3, payment.getAmount());

                stmt.execute();
            }
        }
    }

    @Override
    public void updateOrder(Order order) throws InternalErrorException {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }

        if (order.getOrderID() <= 0) {
            throw new IllegalArgumentException("Order must have a valid OrderID for update");
        }

        try {
            jdbcTemplate.execute((Connection conn) -> {
                try {
                    // Start transaction
                    conn.setAutoCommit(false);

                    // Step 1: Update the main order record
                    updateMainOrder(conn, order);

                    // Step 2: Handle order items (replace all)
                    updateOrderItems(conn, order.getOrderID(), order.getItems());

                    // Step 3: Handle payments (replace all)
                    updatePayments(conn, order.getOrderID(), order.getPayments());

                    // Commit transaction
                    conn.commit();
                    return null;

                } catch (Exception e) {
                    // Rollback on any error
                    try {
                        conn.rollback();
                    } catch (SQLException rollbackEx) {
                        // Log rollback failure if needed
                    }
                    throw new RuntimeException(new InternalErrorException(e));
                } finally {
                    try {
                        conn.setAutoCommit(true);
                    } catch (SQLException e) {
                        // Log if needed
                    }
                }
            });

        } catch (RuntimeException e) {
            if (e.getCause() instanceof InternalErrorException) {
                throw (InternalErrorException) e.getCause();
            } else {
                throw new InternalErrorException(e);
            }
        }
    }

    /**
     * Update the main order record using stored procedure
     */
    private void updateMainOrder(Connection conn, Order order) throws SQLException {
        try (CallableStatement stmt = conn.prepareCall("{call UpdateOrder(?, ?, ?, ?, ?, ?, ?)}")) {
            stmt.setInt(1, order.getOrderID());
            stmt.setInt(2, order.getServerID());
            stmt.setTimestamp(3, java.sql.Timestamp.valueOf(order.getOrderDate()));
            stmt.setBigDecimal(4, order.getSubTotal());
            stmt.setBigDecimal(5, order.getTax());
            stmt.setBigDecimal(6, order.getTip());
            stmt.setBigDecimal(7, order.getTotal());

            stmt.execute();
        }
    }

    /**
     * Implementation using individual item updates
     * This method tries to update existing records and only insert/delete as needed
     */
    private void updateOrderItems(Connection conn, int orderID, List<OrderItem> newItems) throws SQLException {
        // Get existing items from database
        List<OrderItem> existingItems = getExistingOrderItemsByOrderID(conn, orderID);

        // Update/Insert new items
        if (newItems != null) {
            for (OrderItem newItem : newItems) {
                if (newItem.getOrderItemID() > 0) {
                    // Update existing item
                    try (CallableStatement stmt = conn.prepareCall("{call UpdateOrderItem(?, ?, ?, ?)}")) {
                        stmt.setInt(1, newItem.getOrderItemID());
                        stmt.setInt(2, newItem.getItemID());
                        stmt.setInt(3, newItem.getQuantity());
                        stmt.setBigDecimal(4, newItem.getPrice());
                        stmt.execute();
                    }
                } else {
                    // Insert new item
                    try (CallableStatement stmt = conn.prepareCall("{call AddOrderItem(?, ?, ?, ?)}")) {
                        stmt.setInt(1, orderID);
                        stmt.setInt(2, newItem.getItemID());
                        stmt.setInt(3, newItem.getQuantity());
                        stmt.setBigDecimal(4, newItem.getPrice());
                        stmt.execute();
                    }
                }
            }
        }

        // Delete items that are no longer in the new list
        for (OrderItem existingItem : existingItems) {
            boolean stillExists = newItems != null && newItems.stream()
                    .anyMatch(newItem -> newItem.getOrderItemID() == existingItem.getOrderItemID());

            if (!stillExists) {
                try (CallableStatement stmt = conn.prepareCall("{call DeleteOrderItem(?)}")) {
                    stmt.setInt(1, existingItem.getOrderItemID());
                    stmt.execute();
                }
            }
        }
    }

    /**
     * Helper method to get existing order items from database by OrderID
     */
    private List<OrderItem> getExistingOrderItemsByOrderID(Connection conn, int orderID) throws SQLException {
        List<OrderItem> items = new ArrayList<>();
        String sql = """
            SELECT
                OrderItemID,
                ItemID,
                Quantity,
                Price
            FROM OrderItem
            WHERE OrderID = ?;
            """;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, orderID);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    OrderItem item = new OrderItem();
                    item.setOrderItemID(rs.getInt("OrderItemID"));
                    item.setOrderID(orderID);
                    item.setItemID(rs.getInt("ItemID"));
                    item.setQuantity(rs.getInt("Quantity"));
                    item.setPrice(rs.getBigDecimal("Price"));
                    items.add(item);
                }
            }
        }
        return items;
    }

    /**
     * Implementation using individual payment updates
     * This method tries to update existing records and only insert/delete as needed
     */
    private void updatePayments(Connection conn, int orderID, List<Payment> newPayments) throws SQLException {
        List<Payment> existingPayments = getExistingPaymentsByOrderID(conn, orderID);
        // Update/Insert new payments
        if (newPayments != null) {
            for (Payment newPayment : newPayments) {
                if (newPayment.getPaymentID() > 0) {
                    // Update existing payment
                    try (CallableStatement stmt = conn.prepareCall("{call UpdatePayment(?, ?, ?)}")) {
                        stmt.setInt(1, newPayment.getPaymentID());
                        stmt.setInt(2, newPayment.getPaymentTypeID());
                        stmt.setBigDecimal(3, newPayment.getAmount());
                        stmt.execute();
                    }
                } else {
                    // Insert new payment
                    try (CallableStatement stmt = conn.prepareCall("{call AddPayment(?, ?, ?)}")) {
                        stmt.setInt(1, newPayment.getPaymentTypeID());
                        stmt.setInt(2, orderID);
                        stmt.setBigDecimal(3, newPayment.getAmount());
                        stmt.execute();
                    }
                }
            }
        }

        // Delete payments that are no longer in the new list
        for (Payment existingPayment : existingPayments) {
            boolean stillExists = newPayments != null && newPayments.stream()
                    .anyMatch(newPayment -> newPayment.getPaymentID() == existingPayment.getPaymentID());

            if (!stillExists) {
                try (CallableStatement stmt = conn.prepareCall("{call DeletePayment(?)}")) {
                    stmt.setInt(1, existingPayment.getPaymentID());
                    stmt.execute();
                }
            }
        }
    }

    /**
     * Helper method to get existing payments from database by OrderID
     */
    private List<Payment> getExistingPaymentsByOrderID(Connection conn, int orderID) throws SQLException {
        List<Payment> payments = new ArrayList<>();
        String sql = """
            SELECT
                PaymentID,
                PaymentTypeID,
                OrderID,
                Amount
            FROM Payment
            WHERE OrderID = ?;
            """;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, orderID);
            try (ResultSet resultSet = stmt.executeQuery()) {
                while (resultSet.next()) {
                    Payment payment = new Payment();
                    payment.setPaymentID(resultSet.getInt("PaymentID"));
                    payment.setPaymentTypeID(resultSet.getInt("PaymentTypeID"));
                    payment.setOrderID(resultSet.getInt("OrderID"));
                    payment.setAmount(resultSet.getBigDecimal("Amount"));
                    payments.add(payment);
                }
            }
        }
        return payments;
    }


    @Override
    public Order deleteOrder(int id) throws InternalErrorException {
        if (id <= 0) {
            throw new IllegalArgumentException("Order ID must be positive");
        }

        try {
            return jdbcTemplate.execute((Connection conn) -> {
                try {

                    conn.setAutoCommit(false);


                    Order orderToDelete = getOrderById(id);

                    int rowsDeleted = callDeleteCompleteOrderProcedure(conn, id);

                    if (rowsDeleted == 0) {
                        throw new SQLException("No order was deleted");
                    }

                    conn.commit();

                    // Return the deleted order
                    return orderToDelete;

                } catch (RecordNotFoundException e) {
                    // Order doesn't exist
                    try {
                        conn.rollback();
                    } catch (SQLException rollbackEx) {
                        // Log rollback failure if needed
                    }
                    throw new RuntimeException(e);
                } catch (Exception e) {
                    // Rollback on any error
                    try {
                        conn.rollback();
                    } catch (SQLException rollbackEx) {
                        // Log rollback failure if needed
                    }
                    throw new RuntimeException(new InternalErrorException(e));
                } finally {
                    try {
                        conn.setAutoCommit(true);
                    } catch (SQLException e) {
                        // Log if needed
                    }
                }
            });

        } catch (RuntimeException e) {
            if (e.getCause() instanceof InternalErrorException) {
                throw (InternalErrorException) e.getCause();
            } else {
                throw new InternalErrorException(e);
            }
        }
    }

    /**
     * Call the DeleteCompleteOrder stored procedure
     */
    private int callDeleteCompleteOrderProcedure(Connection conn, int orderID) throws SQLException {
        try (CallableStatement stmt = conn.prepareCall("{call DeleteCompleteOrder(?, ?)}")) {
            // Set input parameter
            stmt.setInt(1, orderID);

            // Register output parameter
            stmt.registerOutParameter(2, java.sql.Types.INTEGER);

            // Execute the procedure
            stmt.execute();

            // Get the number of rows deleted
            return stmt.getInt(2);
        }
    }
}
