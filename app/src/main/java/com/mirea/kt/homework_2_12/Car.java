package com.mirea.kt.homework_2_12;

public class Car {
    private String model;
    private String number;
    private int year;

    public Car(String model, String number, int year) {
        this.model = model;
        this.number = number;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
