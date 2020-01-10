package com.example.demo.Enum;

public enum Kitchen {

    POLISH("POLISH"),
    MEXICAN("MEXICAN"),
    ITALIAN("ITALIAN");

    private String kitchen;

    Kitchen(String kitchen) {
        this.kitchen = kitchen;
    }

    public String getKitchen() {
        return kitchen;
    }
}
