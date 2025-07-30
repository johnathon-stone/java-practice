package org.example.data.mappers;

import org.example.model.Order;
import org.example.model.Server;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrderWithServerMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Order order = new Order();

        order.setOrderID(resultSet.getInt("OrderID"));
        order.setServerID(resultSet.getInt("ServerID"));
        order.setOrderDate(resultSet.getObject("OrderDate", LocalDateTime.class));
        order.setSubTotal(resultSet.getBigDecimal("SubTotal"));
        order.setTax(resultSet.getBigDecimal("Tax"));
        order.setTip(resultSet.getBigDecimal("Tip"));
        order.setTotal(resultSet.getBigDecimal("Total"));

        Server server = new Server();

        server.setServerID(resultSet.getInt("Server_ServerID"));
        server.setFirstName(resultSet.getString("Server_FirstName"));
        server.setLastName(resultSet.getString("Server_LastName"));
        server.setHireDate(resultSet.getObject("Server_HireDate", LocalDate.class));
        server.setTermDate(resultSet.getObject("Server_TermDate", LocalDate.class));

        order.setServer(server);

        return order;
    }
}
