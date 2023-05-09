package com.example.pizzalabapp.models;

public enum PizzaSize {

    SMALL("Small",5.00),
    MEDIUM("Medium",7.50),
    LARGE("Large",10.00),
    FAMILY("Family",15.00);

    private String name;
    private Double price;

    private PizzaSize(String name, Double price){
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getName();
    }
}
