package com.example.demo.Dto;

public class Drink extends Meal {

    private long id;
    public boolean isWithLemon;
    public boolean isWithCubes;
    private int capacity;

    public Drink(long id, String name, double price, int capacity) {
        this.id = id;
        super.name = name;
        super.price = price;
        this.capacity = capacity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isWithLemon() {
        return isWithLemon;
    }

    public void setWithLemon(boolean withLemon) {
        isWithLemon = withLemon;
    }

    public boolean isWithCubes() {
        return isWithCubes;
    }

    public void setWithCubes(boolean withCubes) {
        isWithCubes = withCubes;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
