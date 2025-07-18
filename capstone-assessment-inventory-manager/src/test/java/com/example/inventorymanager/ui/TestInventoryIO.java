package com.example.inventorymanager.ui;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestInventoryIO {
    InventoryIO inventoryIO = new InventoryIO();

    @Test
    void testStringAddPaddingWithLongString() {
        String testString = "testStringAddPaddingWithLongString";

        String modifiedString = inventoryIO.stringAddPadding(testString, 40, "*", "b");

        assertEquals(40, modifiedString.length());
    }

    @Test
    void testStringAddPaddingWithShortString() {
        String testString = "testStr";

        String modifiedString = inventoryIO.stringAddPadding(testString, 10, "*", "b");

        assertEquals(10, modifiedString.length());
        assertEquals("*testStr**", modifiedString);
    }

    @Test
    void testStringAddPaddingLeft() {
        String testString = "testStr";

        String modifiedString = inventoryIO.stringAddPadding(testString, 10, "*", "l");

        assertEquals(10, modifiedString.length());
        assertEquals("***testStr", modifiedString);
    }

    @Test
    void testStringAddPaddingRight() {
        String testString = "testStr";

        String modifiedString = inventoryIO.stringAddPadding(testString, 10, "*", "r");

        assertEquals(10, modifiedString.length());
        assertEquals("testStr***", modifiedString);
    }
}
