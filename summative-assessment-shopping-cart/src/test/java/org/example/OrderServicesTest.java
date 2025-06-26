package org.example;

import org.example.shoppingcart.*;
import org.example.model.Item;
import org.example.utilities.Utilities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderServicesTest {
    private final Utilities utilities = new Utilities();
    private OrderServices services;
    private final MenuItems menuItems = new MenuItems();


    @BeforeEach
    void setUp() {
        services = new OrderServices(utilities);
    }

    @Test
    void testPutSingleEntry() {
        String keyNameCheck = "Good Burger";
        int index = 1;
        int testQuantity = 1;
        Item item = new Item(menuItems.getName(index), menuItems.getCost(index), testQuantity) ;

        services.addItem(item);

        assertTrue(services.checkForItem(item));
        assertEquals(item, services.getItemByName(keyNameCheck));
        assertEquals(1, services.getOrderSize());
    }

    @Test
    void testPutMultipleEntries() {
        String keyNameCheck1 = "Good Burger";
        int index1 = 1;
        int testQuantity = 1;
        Item item1 = new Item(menuItems.getName(index1), menuItems.getCost(index1), testQuantity) ;
        String keyNameCheck2 = "Good Chickwich";
        int index2 = 2;
        Item item2 = new Item(menuItems.getName(index2), menuItems.getCost(index2), testQuantity) ;
        String keyNameCheck3 = "Good Taco";
        int index3 = 3;
        Item item3 = new Item(menuItems.getName(index3), menuItems.getCost(index3), testQuantity) ;


        services.addItem(item1);
        services.addItem(item2);
        services.addItem(item3);


        assertEquals(3, services.getOrderSize());
        assertEquals(item1, services.getItemByName(keyNameCheck1));
        assertEquals(item2, services.getItemByName(keyNameCheck2));
        assertEquals(item3, services.getItemByName(keyNameCheck3));
    }

    @Test
    void testPutAdjustEntries() {
        String keyNameCheck = "Good Burger";
        int index = 1;
        int originalQty = 3;
        Item originalItem = new Item(menuItems.getName(index), menuItems.getCost(index), originalQty);
        services.addItem(originalItem);
        int testQuantity = 1;
        Item item = new Item(menuItems.getName(index), menuItems.getCost(index), testQuantity) ;


        services.addItem(item);


        assertTrue(services.checkForItem(item));
        assertEquals(item.toString(), services.getItemByName(keyNameCheck).toString());
        assertEquals(1, services.getOrderSize());
    }

    //Test removal
    @Test
    void removeKeyValuePair() {
        String keyNameCheck = "Good Burger";
        int index = 1;
        int testQuantity = 1;
        Item item = new Item(menuItems.getName(index), menuItems.getCost(index), testQuantity) ;

        services.addItem(item);
        services.removeItem(keyNameCheck, testQuantity);

        assertFalse(services.checkForItem(item));
        assertNull(services.getItemByName(keyNameCheck));
        assertEquals(0, services.getOrderSize());
    }

    @Test
    void adjustQuantityDown() {
        String keyNameCheck = "Good Burger";
        int index = 1;
        int testQuantity1 = 10;
        int testQuantity2 = 9;
        Item item = new Item(menuItems.getName(index), menuItems.getCost(index), testQuantity1) ;

        services.addItem(item);
        services.removeItem(keyNameCheck, testQuantity2);

        assertTrue(services.checkForItem(item));
        assertEquals(1, services.getItemQuantity(keyNameCheck));
    }

    //rename
    @Test
    void removePastZero() {
        String keyNameCheck = "Good Burger";
        int index = 1;
        int testQuantity1 = 10;
        int testQuantity2 = 11;
        Item item = new Item(menuItems.getName(index), menuItems.getCost(index), testQuantity1) ;

        services.addItem(item);
        services.removeItem(keyNameCheck, testQuantity2);

        assertTrue(services.checkForItem(item));
        assertEquals(10, services.getItemQuantity(keyNameCheck));
    }

    //Test empty
    @Test
    void emptyCompleteOrder() {
        int index1 = 1;
        int testQuantity = 1;
        Item item1 = new Item(menuItems.getName(index1), menuItems.getCost(index1), testQuantity) ;
        int index2 = 2;
        Item item2 = new Item(menuItems.getName(index2), menuItems.getCost(index2), testQuantity) ;
        int index3 = 3;
        Item item3 = new Item(menuItems.getName(index3), menuItems.getCost(index3), testQuantity) ;


        services.addItem(item1);
        services.addItem(item2);
        services.addItem(item3);
        services.emptyOrder();

        assertEquals(0, services.getOrderSize());
    }

    @Test
    void checkEmptyForEmpty() {
        boolean isEmpty;

        isEmpty = services.checkForEmpty();

        assertTrue(isEmpty);
    }

    @Test
    void checkNotEmptyForEmpty() {
        int index1 = 1;
        int testQuantity = 1;
        Item item1 = new Item(menuItems.getName(index1), menuItems.getCost(index1), testQuantity) ;


        services.addItem(item1);

        assertFalse(services.checkForEmpty());
    }
}
