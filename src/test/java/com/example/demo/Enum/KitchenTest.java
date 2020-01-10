package com.example.demo.Enum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KitchenTest {

    @Test
    public void testIfReturnsCorrectStringFromEnumType() {
        assertEquals("POLISH", Kitchen.POLISH.getKitchen());
        assertEquals("MEXICAN", Kitchen.MEXICAN.getKitchen());
        assertEquals("ITALIAN", Kitchen.ITALIAN.getKitchen());
    }
}
