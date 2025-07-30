package org.example.data.mappers;

import org.example.model.Payment;
import org.example.model.PaymentType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentMapper implements RowMapper<Payment> {

    @Override
    public Payment mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Payment payment = new Payment();

        payment.setPaymentID(resultSet.getInt("PaymentID"));
        payment.setPaymentTypeID(resultSet.getInt("PaymentTypeID"));
        payment.setOrderID(resultSet.getInt("OrderID"));
        payment.setAmount(resultSet.getBigDecimal("Amount"));

        PaymentType paymentType = new PaymentType();

        paymentType.setPaymentTypeID(resultSet.getInt("PaymentType_PaymentTypeID"));
        paymentType.setPaymentTypeName(resultSet.getString("PaymentType_PaymentTypeName"));

        payment.setPaymentType(paymentType);

        return  payment;
    }
}
