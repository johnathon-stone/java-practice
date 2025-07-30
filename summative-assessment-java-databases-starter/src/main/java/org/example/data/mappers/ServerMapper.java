package org.example.data.mappers;

import org.example.model.Server;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ServerMapper implements RowMapper<Server> {

    @Override
    public Server mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Server server = new Server();
        server.setServerID(resultSet.getInt("ServerID"));
        server.setFirstName(resultSet.getString("FirstName"));
        server.setLastName(resultSet.getString("LastName"));
        server.setHireDate(resultSet.getObject("HireDate", LocalDate.class));
        server.setTermDate(resultSet.getObject("TermDate", LocalDate.class));
        return server;
    }
}
