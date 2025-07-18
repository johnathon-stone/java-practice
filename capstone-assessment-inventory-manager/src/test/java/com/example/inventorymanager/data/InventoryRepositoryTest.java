package com.example.inventorymanager.data;

import com.example.inventorymanager.model.Product;
import com.example.inventorymanager.repository.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;



public class InventoryRepositoryTest {
    private InventoryRepository inventoryRepository;
    private Product testProduct;

    @BeforeEach
    void setUp() {
        inventoryRepository = new InventoryRepositoryInMemory();

        Product product1 = new Product("178", "pant", 1, BigDecimal.valueOf(14.33));
        Product product2 = new Product("143", "shirt", 100, BigDecimal.valueOf(12.33));

        inventoryRepository.addProductToInventory(product1);
        inventoryRepository.addProductToInventory(product2);
    }

    @Test
    void addProduct_ValidProduct_DoesAdd() {
        testProduct = new Product("144", "hat", 10, BigDecimal.valueOf(12.99));
        boolean productDoesNotExist = inventoryRepository.isNotUniqueID(testProduct.getProductID());
        inventoryRepository.addProductToInventory(testProduct);

        assertFalse(productDoesNotExist);
        assertEquals(3, inventoryRepository.getProducts().size());
        assertTrue(inventoryRepository.isNotUniqueID(testProduct.getProductID()));
    }

    @Test
    void testAddProduct_NullProduct_ThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inventoryRepository.addProductToInventory(null);
        });

        assertEquals(2, inventoryRepository.getProducts().size());
        assertEquals("Item cannot be null", exception.getMessage());
    }

    @Test
    void testAddProduct_SameID_DoesNotAdd() {
        testProduct = new Product("178", "chair", 1, BigDecimal.valueOf(14.33));
        inventoryRepository.addProductToInventory(testProduct);

        assertEquals(2, inventoryRepository.getProducts().size());
        assertFalse(inventoryRepository.isUniqueName(testProduct));
    }

    @Test
    void testAddProduct_SameName_DoesNotAdd() {
        testProduct = new Product("188", "pant", 1, BigDecimal.valueOf(14.33));
        inventoryRepository.addProductToInventory(testProduct);

        assertEquals(2, inventoryRepository.getProducts().size());
        assertFalse(inventoryRepository.isNotUniqueID(testProduct.getProductID()));
    }

    @Test
    void testAddProduct_NullProductID_ThrowsException() {
        testProduct = new Product(null, "GoodName", 1, BigDecimal.valueOf(14.33));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inventoryRepository.addProductToInventory(testProduct);
        });

        assertEquals(2, inventoryRepository.getProducts().size());
        assertEquals("Product ID cannot be null or empty", exception.getMessage());
    }

    @Test
    void testAddProduct_EmptyProductID_ThrowsException() {
        testProduct = new Product("", "GoodName", 1, BigDecimal.valueOf(14.33));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inventoryRepository.addProductToInventory(testProduct);
        });

        assertEquals(2, inventoryRepository.getProducts().size());
        assertEquals("Product ID cannot be null or empty", exception.getMessage());
    }

    @Test
    void testAddProduct_NullProductName_ThrowsException() {
        testProduct = new Product("777", null, 1, BigDecimal.valueOf(14.33));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inventoryRepository.addProductToInventory(testProduct);
        });

        assertEquals(2, inventoryRepository.getProducts().size());
        assertEquals("Product name cannot be null or empty", exception.getMessage());
    }

    @Test
    void testAddProduct_EmptyProductName_ThrowsException() {
        testProduct = new Product("777", "", 1, BigDecimal.valueOf(14.33));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inventoryRepository.addProductToInventory(testProduct);
        });

        assertEquals(2, inventoryRepository.getProducts().size());
        assertEquals("Product name cannot be null or empty", exception.getMessage());
    }

    @Test
    void testAddProduct_NegativeQuantity_ThrowsException() {
        testProduct = new Product("777", "GoodName", -1, BigDecimal.valueOf(14.33));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inventoryRepository.addProductToInventory(testProduct);
        });

        assertEquals(2, inventoryRepository.getProducts().size());
        assertEquals("Product quantity cannot be negative", exception.getMessage());
    }

    @Test
    void testAddProduct_ZeroPrice_ThrowsException() {
        testProduct = new Product("777", "GoodName", 10, BigDecimal.valueOf(0));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inventoryRepository.addProductToInventory(testProduct);
        });

        assertEquals(2, inventoryRepository.getProducts().size());
        assertEquals("Product price cannot be zero or less than zero", exception.getMessage());
    }

    @Test
    void testRemoveProduct_DoesRemove() {
        String productID = "178";
        inventoryRepository.removeProductFromInventory(productID);

        assertEquals(1, inventoryRepository.getProducts().size());
        assertFalse(inventoryRepository.isNotUniqueID(productID));
    }
}
