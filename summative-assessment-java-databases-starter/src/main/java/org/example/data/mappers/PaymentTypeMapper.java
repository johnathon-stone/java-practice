package org.example.data.mappers;

import org.example.model.PaymentType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentTypeMapper implements RowMapper<PaymentType> {

    @Override
    public PaymentType mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        PaymentType paymentType = new PaymentType();

        paymentType.setPaymentTypeID(resultSet.getInt("PaymentTypeID"));
        paymentType.setPaymentTypeName(resultSet.getString("PaymentTypeName"));

        return paymentType;
    }
}
