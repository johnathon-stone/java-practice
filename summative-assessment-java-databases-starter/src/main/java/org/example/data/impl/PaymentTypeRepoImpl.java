package org.example.data.impl;

import org.example.data.PaymentTypeRepo;
import org.example.data.exceptions.InternalErrorException;
import org.example.data.mappers.PaymentTypeMapper;
import org.example.model.PaymentType;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PaymentTypeRepoImpl implements PaymentTypeRepo {

    private final JdbcTemplate jdbcTemplate;
    private final PaymentTypeMapper paymentTypeMapper;

    public PaymentTypeRepoImpl(JdbcTemplate jdbcTemplate, PaymentTypeMapper paymentTypeMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.paymentTypeMapper = paymentTypeMapper;
    }

    @Override
    public List<PaymentType> getAll() throws InternalErrorException {
        String sql = """
                SELECT
                	PaymentTypeID,
                	PaymentTypeName
                FROM PaymentType;
                """;

        try {
            return jdbcTemplate.query(sql, paymentTypeMapper);
        } catch (DataAccessException e) {
            throw new InternalErrorException();
        }
    }
}
