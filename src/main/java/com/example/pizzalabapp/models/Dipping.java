package com.example.pizzalabapp.models;

public enum Dipping {
    RANCH("Ranch",1.50),
    GARLIC("Garlic",1.50),
    MARINARA("Marinara",1.50),
    BBQ("BBQ", 1.50),
    BUFFALO("Buffalo", 1.50),
    KETCHUP("Ketchup",1.50);

    private String name;
    private Double price;

    private Dipping(String name, Double price){
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
