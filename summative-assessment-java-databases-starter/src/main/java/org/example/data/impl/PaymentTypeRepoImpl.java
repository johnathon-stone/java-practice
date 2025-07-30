package org.example.data.impl;

import org.example.data.PaymentTypeRepo;
import org.example.data.exceptions.InternalErrorException;
import org.example.data.mappers.PaymentTypeMapper;
import org.example.model.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentTypeRepoImpl implements PaymentTypeRepo {

    private final JdbcTemplate jdbcTemplate;
    private final PaymentTypeMapper paymentTypeMapper;

    public PaymentTypeRepoImpl(@Autowired JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.paymentTypeMapper = new PaymentTypeMapper();
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
