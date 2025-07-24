package org.example.data.mappers;

import org.example.model.Tax;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaxMapper implements RowMapper<Tax> {

    public Tax mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Tax tax = new Tax();
        tax.setTaxID(resultSet.getInt("TaxID"));
        tax.setTaxPercentage(resultSet.getBigDecimal("TaxPercentage"));
        tax.setStartDate(resultSet.getDate("StartDate").toLocalDate());
        tax.setEndDate(resultSet.getDate("EndDate").toLocalDate());
        return tax;
    }
}
