package com.example.demo.View;

import com.example.demo.Dto.Drink;
import com.example.demo.Dto.Lunch;
import com.example.demo.Dto.Meal;
import com.example.demo.Enum.Kitchen;
import com.example.demo.Service.DatabaseInitializator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class MainViewService {

    private DrinkTableGenerator drinkTableGenerator;
    private LunchTableGenerator lunchTableGenerator;
    private MenuTableGenerator menuTableGenerator;
    private DatabaseInitializator initializator;
    private OrderTableGenerator orderTableGenerator;
    private Scanner scan;

    private List<Drink> orderedDrinks;
    private List<Lunch> orderedLunches;
    private double cost;

    @Autowired
    public MainViewService(DrinkTableGenerator drinkTableGenerator, LunchTableGenerator lunchTableGenerator,
                           MenuTableGenerator menuTableGenerator, DatabaseInitializator initializator,
                           OrderTableGenerator orderTableGenerator) {
        this.drinkTableGenerator = drinkTableGenerator;
        this.lunchTableGenerator = lunchTableGenerator;
        this.menuTableGenerator = menuTableGenerator;
        this.orderTableGenerator = orderTableGenerator;
        this.initializator = initializator;
        this.scan = new Scanner(System.in);
        this.orderedDrinks = new ArrayList<>();
        this.orderedLunches = new ArrayList<>();
        this.cost = 0.0;
    }

    public void maintainMenu() throws InterruptedException {
        initializator.drinks = new ArrayList<>();
        initializator.lunches = new ArrayList<>();
        initializator.init();
        String option = null;
        do {
            System.out.println(menuTableGenerator.generateMenu());
            System.out.print("Enter number option: ");
            Scanner scan = new Scanner(System.in);
            option = scan.next();

            switchMenu(option);
        } while(option != "5");
    }

    public void switchMenu(String option) throws InterruptedException {

        switch(option) {
            case "1":
                showDrinkMenu();
                Drink selectedDrink = selectDrink();
                Drink orderedDrink = askForLemonOrCubes(selectedDrink);
                orderedDrinks.add(orderedDrink);
                cost += computeReceipt(cost, orderedDrink, null);
                break;
            case "2":
                showLunchMenu(Kitchen.POLISH);
                Lunch orderedLunch = selectLunch();
                orderedLunches.add(orderedLunch);
                cost += computeReceipt(cost, null, orderedLunch);
                break;
            case "3":
                showLunchMenu(Kitchen.ITALIAN);
                Lunch orderedLunch2 = selectLunch();
                orderedLunches.add(orderedLunch2);
                cost += computeReceipt(cost, null, orderedLunch2);
                break;
            case "4":
                showLunchMenu(Kitchen.MEXICAN);
                Lunch orderedLunch3 = selectLunch();
                orderedLunches.add(orderedLunch3);
                cost += computeReceipt(cost, null, orderedLunch3);
                break;
            case "5":
                System.out.println(orderTableGenerator.generateOrderTable(this.orderedLunches,
                        this.orderedDrinks, String.valueOf(cost)));
                break;
            case "6":
                System.out.println("Shutting down..");
                Thread.sleep(1500);
                System.exit(0);
                break;
            default:
                System.out.println("Wrong input..");
                break;
        }

    }

    private void showDrinkMenu() {
        List<Drink> drinks = initializator.drinks;

        for(Drink drink: drinks) {
            System.out.println(drinkTableGenerator.generateTable(drink));
        }
    }

    private void showLunchMenu(Kitchen kitchenType) {
        List<Lunch> lunches = initializator.lunches;

        for(Lunch lunch: lunches) {
            if(lunch.getKitchenType() == kitchenType) {
                System.out.print(lunchTableGenerator.generateTable(lunch));
            }
        }
    }

    private Lunch selectLunch() {
        System.out.print("Enter number lunch: ");
        Scanner scan = new Scanner(System.in);
        String option = scan.next();

        for(Lunch lunch: initializator.lunches) {
            if(option.contains(String.valueOf(lunch.getId()))) {
                return lunch;
            }
        }
        return null;
    }

    private Drink selectDrink() {
        System.out.print("Enter number drink: ");
        Scanner scan = new Scanner(System.in);
        String option = scan.next();

        for(Drink drink: initializator.drinks) {
            if(option.contains(String.valueOf(drink.getId()))) {
                return drink;
            }
        }
        return null;
    }

    private Drink askForLemonOrCubes(Drink drink) {
        if(drink == null) {
            return null;
        }

        System.out.print("Is drink with lemon ? [true][false]: ");
        String lemon = scan.next();
        boolean isWithLemon = false;

        try {
            isWithLemon = Boolean.parseBoolean(lemon);
        } catch(Exception e) {
            System.out.println("Wrong value..");
        }

        System.out.print("Is drink with cubes ? [true][false]: ");
        String cubes = scan.next();
        boolean isWithCubes = false;

        try {
            isWithCubes = Boolean.parseBoolean(cubes);
        } catch(Exception e) {
            System.out.println("Wrong value..");
        }

        drink.setWithCubes(isWithCubes);
        drink.setWithLemon(isWithLemon);

        return drink;
    }

    private double computeReceipt(double cost, Drink drink, Lunch lunch) {
        if(drink != null) {
            if(drink.isWithLemon()) {
                cost += 1.25;
            }
            if(drink.isWithCubes()) {
                cost += 1.25;
            }

            double drinkPrice = drink.getPrice();
            cost += drinkPrice;

            return cost;
        }

        if(lunch != null) {
            double lunchPrice = lunch.getPrice();
            cost += lunchPrice;

            return cost;
        }

        return 0.00;
    }
}
