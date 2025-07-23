package org.example.data.impl;

import org.example.data.ItemRepo;
import org.example.data.exceptions.InternalErrorException;
import org.example.data.mappers.ItemCategoryMapper;
import org.example.data.mappers.ItemMapper;
import org.example.model.Item;
import org.example.model.ItemCategory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.List;

public class ItemRepoImpl implements ItemRepo {

    private final JdbcTemplate jdbcTemplate;
    private final ItemMapper itemMapper;
    private final ItemCategoryMapper itemCategoryMapper;

    public ItemRepoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.itemMapper = new ItemMapper();
        this.itemCategoryMapper = new ItemCategoryMapper();
    }
    @Override
    public Item getItemById(int id) throws InternalErrorException {
        String sql = """
                SELECT
                    ItemID,
                    ItemCategoryID,
                    ItemName
                    ItemDescription,
                    StartDate,
                    EndDate,
                    UnitPrice
                FROM Item
                WHERE ItemID = ?;
                """;

        try {
            return jdbcTemplate.queryForObject(sql, itemMapper, id);
        } catch (DataAccessException e) {
            throw new InternalErrorException();
        }
    }

    @Override
    public List<Item> getAllAvailableItems(LocalDate today) throws InternalErrorException {
        String sql = """
                SELECT
                    ItemID,
                    ItemCategoryID,
                    ItemName,
                    ItemDescription,
                    StartDate,
                    EndDate,
                    UnitPrice
                FROM Item
                WHERE ? BETWEEN StartDate AND EndDate
                ORDER BY ItemName
                """;

        try {
            return jdbcTemplate.query(sql, itemMapper, today);
        } catch (DataAccessException e) {
            throw new InternalErrorException();
        }
    }

    @Override
    public List<Item> getItemsByCategory(LocalDate today, int itemCategoryID) throws InternalErrorException {
        String sql = """
                SELECT
                    ItemID,
                    ItemCategoryID,
                    ItemName,
                    ItemDescription,
                    StartDate,
                    EndDate,
                    UnitPrice
                FROM Item
                WHERE ? BETWEEN StartDate AND EndDate
                AND ItemCategoryID = ?
                ORDER BY ItemName
                """;

        try {
            return jdbcTemplate.query(sql, itemMapper, today, itemCategoryID);
        } catch (DataAccessException e) {
            throw new InternalErrorException();
        }
    }

    @Override
    public List<ItemCategory> getAllItemCategories() throws InternalErrorException {
        String sql = """
                SELECT
                    ItemCategoryID,
                    ItemCategoryName
                FROM ItemCategory
                ORDER BY ItemCategoryName;
                """;

        try {
            return jdbcTemplate.query(sql, itemCategoryMapper);
        } catch (DataAccessException e) {
            throw new InternalErrorException();
        }
    }
}
