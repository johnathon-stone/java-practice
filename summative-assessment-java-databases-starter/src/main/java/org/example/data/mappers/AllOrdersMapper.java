package org.example.data.mappers;

import org.example.model.Order;
import org.example.model.Server;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class AllOrdersMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Order order = new Order();
        order.setOrderID(resultSet.getInt("OrderID"));
        order.setOrderDate(resultSet.getObject("OrderDate", LocalDateTime.class));
        order.setTotal(resultSet.getBigDecimal("Total"));

        Server server = new Server();
        server.setFirstName(resultSet.getString("FirstName"));
        server.setLastName(resultSet.getString("LastName"));
        order.setServer(server);

        return order;
    }
}
