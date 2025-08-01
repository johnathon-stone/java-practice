package org.example.data;

import org.example.data.exceptions.InternalErrorException;
import org.example.model.Item;
import org.example.model.ItemCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ItemRepoImplTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ItemRepo itemRepo;

    @BeforeEach
    void setUp() {
        jdbcTemplate.execute("{call set_known_good_state()}");
    }

    @Test
    void getItemById_ValidId_ReturnsItem() throws Exception {
        int validId = 1;

        Item result = itemRepo.getItemById(validId);

        assertNotNull(result);
        assertEquals(validId, result.getItemID());
        assertNotNull(result.getItemName());
        assertNotNull(result.getItemDescription());
        assertNotNull(result.getStartDate());
        assertNotNull(result.getUnitPrice());
        assertTrue(result.getUnitPrice().compareTo(BigDecimal.ZERO) >= 0);
    }

    @Test
    void getItemById_InvalidId_ThrowsException() throws Exception {
        int invalidId = -1;

        assertThrows(Exception.class, () -> itemRepo.getItemById(invalidId));
    }

    @Test
    void getAllAvailableItems_ValidDate_ReturnsAvailableItems() throws Exception {
        LocalDate testDate = LocalDate.now();

        List<Item> result = itemRepo.getAllAvailableItems(testDate);

        assertNotNull(result);
    }

    @Test
    void getAllAvailableItems_InvalidDate_ThrowsException() throws InternalErrorException {
        LocalDate testDate = LocalDate.now().minusYears(20);

        List<Item> result = itemRepo.getAllAvailableItems(testDate);

        assertThrows(InternalErrorException.class, () -> itemRepo.getAllAvailableItems(testDate));
    }

    @Test
    void getItemsByCategory_ValidData_ReturnsItems() throws Exception {
        LocalDate testDate = LocalDate.now();
        int validCategoryId = 1;

        List<Item> result = itemRepo.getItemsByCategory(testDate, validCategoryId);

        assertNotNull(result);
        assertEquals(5, result.size());
    }

    @Test
    void getItemsByCategory_InvalidData_ReturnsEmpty() throws Exception {
        LocalDate testDate = LocalDate.now().minusYears(20);
        int invalidCategoryId = 999;

        List<Item> result = itemRepo.getItemsByCategory(testDate, invalidCategoryId);

        assertNotNull(result);
        assertEquals(0, itemRepo.getItemsByCategory(testDate, invalidCategoryId).size());
    }

    @Test
    void getAllItemCategories_ReturnsAllItemCategories() throws Exception {
        List<ItemCategory> result = itemRepo.getAllItemCategories();

        assertNotNull(result);
        assertEquals(7, result.size());
    }
}
