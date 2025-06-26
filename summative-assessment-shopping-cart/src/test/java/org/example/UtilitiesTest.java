package org.example;

import org.example.utilities.Utilities;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UtilitiesTest {
    private final Utilities utilities = new Utilities();

    @Test
    void checkInvalidInteger() {
        int badInteger = -10;
        int goodInteger = 1;


        assertFalse(utilities.checkInteger(badInteger));
        assertTrue(utilities.checkInteger(goodInteger));
    }

    @Test
    void checkEmpty() {
        String badString1 = "      ";
        String badString2 = "";

        assertTrue(utilities.checkString(badString1));
        assertTrue(utilities.checkString(badString2));
    }
}
