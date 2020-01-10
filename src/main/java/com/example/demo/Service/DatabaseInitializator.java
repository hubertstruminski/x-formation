package com.example.demo.Service;

import com.example.demo.Dto.Course;
import com.example.demo.Dto.Drink;
import com.example.demo.Dto.Lunch;
import com.example.demo.Enum.Kitchen;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DatabaseInitializator {

    public List<Drink> drinks;
    public List<Lunch> lunches;

    public DatabaseInitializator() {
        this.drinks = new ArrayList<>();
        this.lunches = new ArrayList<>();
    }

    public void init() {
        addDrinks(this.drinks);
        addLunches(this.lunches);
    }

    public void addDrinks(List<Drink> drinks) {
        drinks.add(new Drink(1, "Coca-cola", 15.00, 350));
        drinks.add(new Drink(2, "Tea", 7.50, 250));
        drinks.add(new Drink(3, "Water", 3.50, 250));
        drinks.add(new Drink(4, "Fanta", 4.50, 350));
    }

    public void addLunches(List<Lunch> lunches) {
        Course mainCourse1 = new Course(1, "Chicken with potatoes",500);
        Course mainCourse2 = new Course(2, "Fish with tomatoes", 750);
        Course mainCourse3 = new Course(3, "Beef with salad",650);
        Course mainCourse4 = new Course(4, "Sushi", 250);
        Course mainCourse5 = new Course(5, "Head first", 350);
        Course mainCourse6 = new Course(6, "Grill meet", 420);

        Course dessert1 = new Course(7, "Ice cream", 200);
        Course dessert2 = new Course(8, "Apple cake", 125);
        Course dessert3 = new Course(9, "Orange cake", 75);
        Course dessert4 = new Course(10, "Fresh fruits", 250);
        Course dessert5 = new Course(11, "Ice-Apple-Mango cake", 78);
        Course dessert6 = new Course(12, "Strawberries", 65);

        lunches.add(new Lunch(1, "Wake up!", 75.00, mainCourse1, dessert1, Kitchen.POLISH));
        lunches.add(new Lunch(2, "Welcome meal", 64.00, mainCourse2, dessert2, Kitchen.POLISH));
        lunches.add(new Lunch(3, "Mexico dinner roll up", 42.00, mainCourse3, dessert3, Kitchen.MEXICAN));
        lunches.add(new Lunch(4, "Mexico sushi fish dinner", 54.00, mainCourse4, dessert4, Kitchen.MEXICAN));
        lunches.add(new Lunch(5, "Spaghetti", 65.00, mainCourse5, dessert5, Kitchen.ITALIAN));
        lunches.add(new Lunch(6, "Grill pasta", 112.35, mainCourse6, dessert6, Kitchen.ITALIAN));
    }
}
