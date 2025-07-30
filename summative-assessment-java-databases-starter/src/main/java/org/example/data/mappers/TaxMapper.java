package org.example.data.mappers;

import org.example.model.Tax;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class TaxMapper implements RowMapper<Tax> {

    @Override
    public Tax mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Tax tax = new Tax();
        tax.setTaxID(resultSet.getInt("TaxID"));
        tax.setTaxPercentage(resultSet.getBigDecimal("TaxPercentage"));
        tax.setStartDate(resultSet.getObject("StartDate", LocalDate.class));
        tax.setEndDate(resultSet.getObject("EndDate", LocalDate.class));
        return tax;
    }
}
