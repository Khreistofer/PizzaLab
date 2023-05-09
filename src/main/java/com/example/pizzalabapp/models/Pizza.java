package com.example.pizzalabapp.models;

import java.util.ArrayList;

public class Pizza {
    private int dippingNum;
    private int drinkNum;
    private int pizzaNum;
    private double toppingsCost;
    private PizzaSize size;
    private Drink drink;
    private Dipping dipping;
    private ArrayList<Topping> toppings = new ArrayList<>();
    private double tax = 1.10;

    public Pizza(){
        size = PizzaSize.SMALL;
        drink = Drink.PEPSI;
        dipping = Dipping.BBQ;
        pizzaNum = 1;
        drinkNum = 0;
        dippingNum = 0;
        toppingsCost = 0;
    }

    public Pizza(int dippingNum, int drinkNum, int pizzaNum, double toppingsCost, PizzaSize size,
                 Drink drink, Dipping dipping, ArrayList<Topping> toppings, double tax) {
        this.dippingNum = dippingNum;
        this.drinkNum = drinkNum;
        this.pizzaNum = pizzaNum;
        this.toppingsCost = toppingsCost;
        this.size = size;
        this.drink = drink;
        this.dipping = dipping;
        this.toppings = toppings;
        this.tax = tax;
    }

    public void setDippingNum(int dippingNum) {
        this.dippingNum = dippingNum;
    }

    public void setDrinkNum(int drinkNum) {
        this.drinkNum = drinkNum;
    }

    public void setPizzaNum(int pizzaNum) {
        this.pizzaNum = pizzaNum;
    }

    public void setSize(PizzaSize size) {
        this.size = size;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public void setDipping(Dipping dipping) {
        this.dipping = dipping;
    }

    public void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings;
    }

    public void addTopping(Topping t){
        toppings.add(t);
        toppingsCost += t.getPrice();
    }

    public void setTax(double tax) {
        this.tax = tax;
    }


    public String orderText(){
        String res = "";
        if(pizzaNum>0){
            res += "Pizzas : "+this.pizzaNum+" "+this.size+" @ $"+calculateCost(this.pizzaNum,this.size.getPrice())+"\n";
        }
        if(!toppings.isEmpty() && pizzaNum>0){
            res += "Toppings : ";
            for(Topping t: toppings){
                res += t.toString()+",\n";
            }
        }
        if(drinkNum>0){
            res += "Drinks :"+this.drinkNum+" "+this.drink+" @ $"+calculateCost(this.drinkNum,this.drink.getPrice())+"\n";
        }
        if(dippingNum>0){
            res += "Dips : "+this.dippingNum+" "+this.dipping+" @ $"+calculateCost(this.dippingNum,this.dipping.getPrice())+"\n";
        }
        return res;
    }

    private double calculateCost(int num,double price){
        return num * price;
    }

    public double calculateOrderCost() {
        return (calculateCost(pizzaNum, size.getPrice()) + calculateCost(drinkNum, drink.getPrice()) + calculateCost(dippingNum, dipping.getPrice()) + toppingsCost) * tax;
    }
}
