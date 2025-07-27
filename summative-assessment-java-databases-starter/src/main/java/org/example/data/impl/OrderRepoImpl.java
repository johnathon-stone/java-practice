package org.example.data.impl;

import org.example.data.OrderRepo;
import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.model.Order;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class OrderRepoImpl implements OrderRepo {

    @Override
    public Order getOrderById(int id) throws RecordNotFoundException, InternalErrorException {
        String sql = """
                SELECT ord.OrderID, ord.ServerID, ord.OrderDate, ord.Tax, ord.Tip, ord.Total,
                	ser.FirstName, ser.LastName, ser.HireDate, ser.TermDate, oi.OrderItemID, oi.ItemID, oi.Quantity, oi.Price,
                    i.ItemCategoryID, i.ItemName, i.ItemDescription, i.StartDate, i.EndDate, i.UnitPrice, p.PaymentID, p.PaymentTypeID, p.Amount,
                    pt.PaymentTypeName FROM `Order` ord
                INNER JOIN `Server` AS ser ON ord.ServerID = ser.ServerID
                INNER JOIN OrderItem AS oi ON ord.OrderID = oi.OrderID
                INNER JOIN Item AS i ON oi.ItemID = i.ItemID
                INNER JOIN Payment AS p ON ord.OrderID = p.OrderID
                INNER JOIN PaymentType AS pt ON p.PaymentTypeID = pt.PaymentTypeID
                WHERE ord.OrderID = ?;
                """;

        try {
            return jdbcTemplate.queryForObject(sql, itemMapper, id);
        } catch (DataAccessException e) {
            throw new InternalErrorException();
        }
    }


    @Override
    public List<Order> getAllOrders() throws InternalErrorException, RecordNotFoundException {
        return List.of();
    }

    @Override
    public Order addOrder(Order order) throws InternalErrorException {
        return null;
    }

    @Override
    public void updateOrder(Order order) throws InternalErrorException {

    }

    @Override
    public Order deleteOrder(int id) throws InternalErrorException {
        return null;
    }
}
