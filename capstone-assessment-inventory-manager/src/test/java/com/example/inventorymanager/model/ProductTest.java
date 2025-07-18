package com.example.inventorymanager.model;

import com.example.inventorymanager.repository.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ProductTest {
    private InventoryRepository inventoryRepository;
    private Product testProduct;

    @BeforeEach
    void setUp() {
        inventoryRepository = new InventoryRepositoryInMemory();
        testProduct = new Product("1234", "TestName", 11, BigDecimal.valueOf(7.77));

        inventoryRepository.addProductToInventory(testProduct);
    }

    @Test
    void testGetProductID() {
        String result = testProduct.getProductID();

        assertEquals("1234", result);
    }

    @Test
    void testGetProductName() {
        String result = testProduct.getProductName();

        assertEquals("TestName", result);
    }

    @Test
    void testGetProductQuantity() {
        int result = testProduct.getProductQuantity();

        assertEquals(11, result);
    }

    @Test
    void testGetProductPrice() {
        String result = String.valueOf(testProduct.getProductPrice());

        assertEquals("7.77", result);
    }

    @Test
    void testSetProductID() {
        String newProductID = "777";

        testProduct.setProductID(newProductID);

        assertEquals("777", testProduct.getProductID());
    }

    @Test
    void testSetProductName() {
        String newProductName = "NewTestName";

        testProduct.setProductName(newProductName);

        assertEquals("NewTestName", testProduct.getProductName());
    }

    @Test
    void testSetProductQuantity() {
        int newProductQuantity = 100;

        testProduct.setProductQuantity(newProductQuantity);

        assertEquals(newProductQuantity, testProduct.getProductQuantity());
    }

    @Test
    void testSetProductPrice() {
        BigDecimal newProductPrice = BigDecimal.valueOf(12.33);

        testProduct.setProductPrice(newProductPrice);

        assertEquals(newProductPrice, testProduct.getProductPrice());
    }
}
