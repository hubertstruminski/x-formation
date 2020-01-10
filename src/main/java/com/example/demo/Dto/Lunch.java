package com.example.demo.Dto;

import com.example.demo.Enum.Kitchen;

public class Lunch extends Meal {

    private long id;
    private Course mainCourse;
    private Course dessert;
    private Kitchen kitchenType;

    public Lunch(long id, String name, double price, Course mainCourse, Course dessert, Kitchen kitchenType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.mainCourse = mainCourse;
        this.dessert = dessert;
        this.kitchenType = kitchenType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Course getMainCourse() {
        return mainCourse;
    }

    public void setMainCourse(Course mainCourse) {
        this.mainCourse = mainCourse;
    }

    public Course getDessert() {
        return dessert;
    }

    public void setDessert(Course dessert) {
        this.dessert = dessert;
    }

    public Kitchen getKitchenType() {
        return kitchenType;
    }

    public void setKitchenType(Kitchen kitchenType) {
        this.kitchenType = kitchenType;
    }
}
