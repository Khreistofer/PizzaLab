package com.example.pizzalabapp.models;

public class PayPal extends PaymentStrategy{
    @Override
    public String checkout() {
        return "Proceeding to checkout using PayPal";
    }
}
