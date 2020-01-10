package com.example.demo;

import com.example.demo.Dto.Drink;
import com.example.demo.Dto.Lunch;
import com.example.demo.Service.DatabaseInitializator;
import com.example.demo.View.DrinkTableGenerator;
import com.example.demo.View.LunchTableGenerator;
import com.example.demo.View.MainViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private DrinkTableGenerator drinkTableGenerator;
    private DatabaseInitializator databaseInitializator;
    private LunchTableGenerator lunchTableGenerator;
    private MainViewService mainViewService;

    @Autowired
    public DemoApplication(DrinkTableGenerator drinkTableGenerator, DatabaseInitializator initializator,
                           LunchTableGenerator lunchTableGenerator,
                           MainViewService mainViewService) {
        this.databaseInitializator = initializator;
        this.drinkTableGenerator = drinkTableGenerator;
        this.lunchTableGenerator = lunchTableGenerator;
        this.mainViewService = mainViewService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        databaseInitializator.init();
        List<Drink> drinks = databaseInitializator.drinks;
        List<Lunch> lunches = databaseInitializator.lunches;

        mainViewService.maintainMenu();

        for(Drink drink: drinks) {
            System.out.println(drinkTableGenerator.generateTable(drink));
        }

        for(Lunch lunch: lunches) {
            System.out.println(lunchTableGenerator.generateTable(lunch));
        }


        System.out.print("Enter name: ");
        Scanner scan = new Scanner(System.in);
        String s = scan.next();


        System.out.println("Klient: " + s);
    }
}
