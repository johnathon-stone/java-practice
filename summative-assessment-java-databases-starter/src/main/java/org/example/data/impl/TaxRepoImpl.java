package org.example.data.impl;

import org.example.data.TaxRepo;
import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.data.mappers.TaxMapper;
import org.example.model.Tax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class TaxRepoImpl implements TaxRepo {

    private final JdbcTemplate jdbcTemplate;
    private final TaxMapper taxMapper;

    public TaxRepoImpl(@Autowired JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.taxMapper = new TaxMapper();
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
                WHERE ? BETWEEN StartDate AND IFNULL(EndDate, '9999-12-31');
                """;

        try {
            return jdbcTemplate.queryForObject(sql, taxMapper, dateOf);
        } catch (DataAccessException e) {
            throw new InternalErrorException();
        }
    }
}
