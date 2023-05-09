package com.example.pizzalabapp.models;

public class CreditCard extends PaymentStrategy{
    @Override
    public String checkout() {
        return "Proceeding to checkout using Credit Card";
    }
}
