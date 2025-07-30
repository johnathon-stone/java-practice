package org.example.data.impl;

import org.example.data.ServerRepo;
import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.data.mappers.ServerMapper;
import org.example.model.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class ServerRepoImpl implements ServerRepo {

    private final JdbcTemplate jdbcTemplate;
    private final ServerMapper serverMapper;

    public ServerRepoImpl(@Autowired JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.serverMapper = new ServerMapper();
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
                WHERE ? >= HireDate
                	AND (TermDate IS NULL OR ? <= TermDate);
                """;

        try {
            return jdbcTemplate.query(sql, serverMapper, date, date);
        } catch (DataAccessException e) {
            throw new InternalErrorException();
        }
    }
}
