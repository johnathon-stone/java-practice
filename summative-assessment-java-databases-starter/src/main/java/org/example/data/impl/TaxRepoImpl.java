package org.example.data.impl;

import org.example.data.TaxRepo;
import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.data.mappers.TaxMapper;
import org.example.model.Tax;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;

public class TaxRepoImpl implements TaxRepo {

    private final JdbcTemplate jdbcTemplate;
    private final TaxMapper taxMapper;

    public TaxRepoImpl(JdbcTemplate jdbcTemplate, TaxMapper taxMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.taxMapper = taxMapper;
    }

    @Override
    public Tax getCurrentTax(LocalDate dateOf) throws InternalErrorException, RecordNotFoundException {
        String sql = """
                SELECT
                	TaxID,
                	TaxPercentage,
                	StartDate,
                	EndDate
                FROM Tax
                WHERE ? BETWEEN StartDate AND EndDate;
                """;

        try {
            return jdbcTemplate.queryForObject(sql, taxMapper, dateOf);
        } catch (DataAccessException e) {
            throw new InternalErrorException();
        }
    }
}
