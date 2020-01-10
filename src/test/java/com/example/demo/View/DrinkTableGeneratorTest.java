package com.example.demo.View;

import com.example.demo.Dto.Drink;
import com.example.demo.Service.DatabaseInitializator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

public class DrinkTableGeneratorTest {

    @Mock
    private DrinkTableGenerator drinkTableGenerator;

    @Test
    public void testIfTableStringNotEmpty() {
        Drink drink = new Drink(1, "Coca-cola", 15.00, 350);

        when(drinkTableGenerator.generateTable(drink)).thenReturn("<table>");
        drinkTableGenerator.generateTable(drink);

        verify(drinkTableGenerator, atLeastOnce()).generateTable(drink);
    }
}
