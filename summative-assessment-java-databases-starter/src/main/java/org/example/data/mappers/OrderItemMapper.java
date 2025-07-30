package org.example.data.mappers;

import org.example.model.Item;
import org.example.model.OrderItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class OrderItemMapper implements RowMapper<OrderItem> {

    @Override
    public OrderItem mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        OrderItem orderItem = new OrderItem();

        orderItem.setOrderItemID(resultSet.getInt("OrderItemID"));
        orderItem.setOrderID(resultSet.getInt("OrderID"));
        orderItem.setItemID(resultSet.getInt("ItemID"));
        orderItem.setQuantity(resultSet.getInt("Quantity"));
        orderItem.setPrice(resultSet.getBigDecimal("Price"));

        Item item = new Item();

        item.setItemID(resultSet.getInt("Item_ItemID"));
        item.setItemCategoryID(resultSet.getInt("Item_ItemCategoryID"));
        item.setItemName(resultSet.getString("Item_ItemName"));
        item.setItemDescription(resultSet.getString("Item_ItemDescription"));
        item.setStartDate(resultSet.getObject("Item_StartDate", LocalDate.class));
        item.setEndDate(resultSet.getObject("Item_EndDate", LocalDate.class));
        item.setUnitPrice(resultSet.getBigDecimal("Item_UnitPrice"));

        orderItem.setItem(item);

        return orderItem;
    }
}
