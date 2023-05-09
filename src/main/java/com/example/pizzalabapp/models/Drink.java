package com.example.pizzalabapp.models;

public enum Drink {

    PEPSI("Pepsi",1.00),
    JUICE("Juice",1.25),
    SEVEN_UP("7UP",1.00),
    MIRANDA("Miranda",1.00),
    ICE_TEA("Ice Tea",1.50),
    ENERGY("Energy Drink",1.25);

    private String name;
    private Double price;

    private Drink(String name,Double price){
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
