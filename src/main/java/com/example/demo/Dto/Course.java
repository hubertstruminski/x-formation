package com.example.demo.Dto;

public class Course extends Meal {

    private long id;
    public int weight;

    public Course(long id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
