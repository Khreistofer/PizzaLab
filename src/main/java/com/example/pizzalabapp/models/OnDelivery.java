package com.example.pizzalabapp.models;

public class OnDelivery extends PaymentStrategy{
    @Override
    public String checkout() {
        return "Payment on delivery";
    }
}
