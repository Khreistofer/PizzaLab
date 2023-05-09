package com.example.pizzalabapp.controllers;

import com.example.pizzalabapp.models.CreditCard;
import com.example.pizzalabapp.models.OnDelivery;
import com.example.pizzalabapp.models.PayPal;
import com.example.pizzalabapp.models.PaymentStrategy;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PaymentController {
    private PaymentStrategy paymentStrategy;
    @FXML
    Label checkoutText;
    @FXML
    Button creditCardBtn, paypalBtn, onDeliveryBtn, confirmPayment;
    private double totalCost;

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    private void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void setCheckoutText(double total){
        String formattedTotal = String.format("%.2f",total);
        checkoutText.setText(this.paymentStrategy.checkout()+"\nTotal : $"+formattedTotal);
    }

    @FXML
    public void onCreditCardBtnClicked(MouseEvent event){
        setPaymentStrategy(new CreditCard());
        setCheckoutText(totalCost);
    }

    @FXML
    public void onPayPalBtnClicked(MouseEvent event){
        setPaymentStrategy(new PayPal());
        setCheckoutText(totalCost);
    }

    @FXML
    public void onOnDeliveryClicked(MouseEvent event){
        setPaymentStrategy(new OnDelivery());
        setCheckoutText(totalCost);
    }

    @FXML
    public void onConfirmPaymentBtnClicked(MouseEvent event){
        if(paymentStrategy == null){
            checkoutText.setText("Please specify payment method then try again");
            return;
        }
        Stage stage =(Stage) confirmPayment.getScene().getWindow();
        stage.close();
    }
}
