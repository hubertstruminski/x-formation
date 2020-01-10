package com.example.demo.Service;

import com.example.demo.Dto.Drink;
import com.example.demo.Dto.Lunch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseInitializatorTest {

    private DatabaseInitializator databaseInitializator;

    @BeforeEach
    void setUp() {
        this.databaseInitializator = new DatabaseInitializator();
    }

    @Test
    public void testIfFieldsAreEmptyBeforeInitializationStep() {
        List<Drink> drinks = databaseInitializator.drinks;
        List<Lunch> lunches = databaseInitializator.lunches;

        assertEquals(0, drinks.size());
        assertEquals(0, lunches.size());
    }

    @Test
    public void testIfNumberOfElementsCorrectAfterAdd() {
        databaseInitializator.addDrinks(databaseInitializator.drinks);
        databaseInitializator.addLunches(databaseInitializator.lunches);

        assertEquals(4, databaseInitializator.drinks);
        assertEquals(6, databaseInitializator.lunches);
    }
}
