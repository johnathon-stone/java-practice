package org.example.data.mappers;

import org.example.model.Server;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServerMapper implements RowMapper<Server> {

    public Server mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Server server = new Server();
        server.setServerID(resultSet.getInt("ServerID"));
        server.setFirstName(resultSet.getString("FirstName"));
        server.setLastName(resultSet.getString("LastName"));
        server.setHireDate(resultSet.getDate("HireDate").toLocalDate());
        server.setTermDate(resultSet.getDate("TermDate").toLocalDate());
        return server;
    }
}
