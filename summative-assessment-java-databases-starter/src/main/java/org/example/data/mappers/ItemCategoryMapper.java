package org.example.data.mappers;

import org.example.model.ItemCategory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemCategoryMapper implements RowMapper<ItemCategory> {

    public ItemCategory mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        ItemCategory itemCategory = new ItemCategory();
        itemCategory.setItemCategoryID(resultSet.getInt("ItemCategoryID"));
        itemCategory.setItemCategoryName(resultSet.getString("ItemCategoryName"));
        return itemCategory;
    }
}
