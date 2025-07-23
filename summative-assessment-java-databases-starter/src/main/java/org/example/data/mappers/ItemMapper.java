package org.example.data.mappers;

import org.example.model.Item;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemMapper implements RowMapper<Item> {

    public Item mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Item item = new Item();
        item.setItemID(resultSet.getInt("ItemID"));
        item.setItemCategoryID(resultSet.getInt("ItemCategoryID"));
        item.setItemName(resultSet.getString("ItemName"));
        item.setItemDescription(resultSet.getString("ItemDescription"));
        item.setStartDate(resultSet.getDate("StartDate").toLocalDate());
        item.setEndDate(resultSet.getDate("EndDate").toLocalDate());
        item.setUnitPrice(resultSet.getBigDecimal("UnitPrice"));
        return item;
    }
}
