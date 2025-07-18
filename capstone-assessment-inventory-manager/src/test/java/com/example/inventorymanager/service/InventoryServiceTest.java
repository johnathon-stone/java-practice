package com.example.inventorymanager.service;

import com.example.inventorymanager.model.Product;
import com.example.inventorymanager.repository.InventoryRepository;
import com.example.inventorymanager.repository.InventoryRepositoryInMemory;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class InventoryServiceTest {
    private InventoryRepository inventoryRepository;
    private InventoryService inventoryService;
    private Product testProduct;

    @BeforeEach
    void setUp() {
        inventoryRepository = new InventoryRepositoryInMemory();
        inventoryService = new InventoryService(inventoryRepository);
        testProduct = new Product("111", "TestName", 11, BigDecimal.valueOf(1.11));
    }

    @Test
    void testAddProduct() {
        int beforeSize = inventoryRepository.getProducts().size();

        inventoryService.addProduct(testProduct);


        assertEquals(0, beforeSize);
        assertEquals(1, inventoryRepository.getProducts().size());
        assertEquals(testProduct, inventoryRepository.getProducts().get("111"));
    }

    @Test
    void testRemoveProduct() {
        inventoryService.addProduct(testProduct);
        int beforeSize = inventoryRepository.getProducts().size();

        inventoryService.removeProduct("111");

        assertEquals(1, beforeSize);
        assertEquals(0, inventoryRepository.getProducts().size());
    }

    @Test
    void testUpdateProduct() {
        inventoryService.addProduct(testProduct);
        testProduct = new Product("111", "NewTestName", 22, BigDecimal.valueOf(2.22));

        inventoryService.updateProduct(testProduct);

        assertEquals(1, inventoryRepository.getProducts().size());
        assertEquals(testProduct, inventoryRepository.getProducts().get("111"));
        assertEquals("NewTestName", inventoryRepository.getProducts().get("111").getProductName());
    }

    @Test
    void testGetProductById() {
        int beforeSize = inventoryRepository.getProducts().size();
        inventoryRepository.addProductToInventory(testProduct);

        inventoryService.getProduct(testProduct.getProductID(), 1);

        assertEquals(0, beforeSize);
        assertEquals(1, inventoryRepository.getProducts().size());
        assertEquals("111", inventoryRepository.getProducts().get("111").getProductID());
    }

    @Test
    void testGetProductByName() {
        int beforeSize = inventoryRepository.getProducts().size();
        inventoryRepository.addProductToInventory(testProduct);

        inventoryService.getProduct(testProduct.getProductName(), 2);

        assertEquals(0, beforeSize);
        assertEquals(1, inventoryRepository.getProducts().size());
        assertEquals("TestName", inventoryRepository.getProducts().get("111").getProductName());
    }
}
