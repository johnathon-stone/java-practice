package org.example.data.impl;

import org.example.data.ServerRepo;
import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.data.mappers.ServerMapper;
import org.example.model.Server;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.List;

public class ServerRepoImpl implements ServerRepo {

    private final JdbcTemplate jdbcTemplate;
    private final ServerMapper serverMapper;

    public ServerRepoImpl(JdbcTemplate jdbcTemplate, ServerMapper serverMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.serverMapper = serverMapper;
    }

    @Override
    public Server getServerById(int id) throws InternalErrorException, RecordNotFoundException {
        String sql = """
                SELECT
                	ServerID,
                	FirstName,
                	LastName,
                	HireDate,
                	TermDate
                FROM `Server`
                WHERE ServerID = ?;
                """;

        try {
            return jdbcTemplate.queryForObject(sql, serverMapper, id);
        } catch (DataAccessException e) {
            throw new InternalErrorException();
        }
    }

    @Override
    public List<Server> getAllAvailableServers(LocalDate date) throws InternalErrorException {
        String sql = """
                SELECT
                	ServerID,
                	FirstName,
                	LastName,
                	HireDate,
                	TermDate
                FROM `Server`
                WHERE ? BETWEEN HireDate AND TermDate;
                """;

        try {
            return jdbcTemplate.query(sql, serverMapper, date);
        } catch (DataAccessException e) {
            throw new InternalErrorException();
        }
    }
}
