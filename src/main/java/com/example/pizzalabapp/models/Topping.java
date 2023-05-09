package com.example.pizzalabapp.models;

public enum Topping {

    CHEESE("Cheese",1.00),
    PEPPERONI("Pepperoni",1.75),
    MUSHROOMS("Mushrooms",1.25),
    TOMATO("Tomato",1.25),
    SAUSAGE("Sausage",1.75),
    ONION("Onion",1.50),
    PINEAPPLE("Pineapple",1.75),
    OLIVES("Olives",1.25);

    private String name;
    private Double price;

    private Topping(String name, Double price){
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
        return getName() + " @ $" + getPrice();
    }
}
