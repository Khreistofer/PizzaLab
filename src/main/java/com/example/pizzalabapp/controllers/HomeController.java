package com.example.pizzalabapp.controllers;

import com.example.pizzalabapp.PizzaLabApp;
import com.example.pizzalabapp.models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HomeController {
    @FXML
    TextField numPizzas, numDrinks, numDips;
    @FXML
    CheckBox cheese,pepperonis,olives,mushrooms,pineapples,tomatoes,sausages,onions;
    @FXML
    RadioButton small,medium,large,family;
    @FXML
    RadioButton pepsi,sevenUp,energyDrink,juice,iceTea,miranda;
    @FXML
    RadioButton bbq,garlic,ranch,marinara,ketchup,buffalo;
    @FXML
    TextArea receipt;
    @FXML
    Button confirm;
    private double totalCost = 0;

    @FXML
    void onAddToReceiptClicked(MouseEvent event){
        Pizza order = new Pizza();
        int pizzaCount = Integer.parseInt(numPizzas.getText());
        int drinksCount = Integer.parseInt(numDrinks.getText());
        int dipsCount = Integer.parseInt(numDips.getText());
        String orderText;
        //Size
        if(small.isSelected()){
            order.setSize(PizzaSize.SMALL);
        } else if (medium.isSelected()) {
            order.setSize(PizzaSize.MEDIUM);
        } else if (large.isSelected()) {
            order.setSize(PizzaSize.LARGE);
        } else {
            order.setSize(PizzaSize.FAMILY);
        }
        //Toppings
        if(cheese.isSelected()){
            order.addTopping(Topping.CHEESE);
        }
        if (olives.isSelected()){
            order.addTopping(Topping.OLIVES);
        }
        if (tomatoes.isSelected()){
            order.addTopping(Topping.TOMATO);
        }
        if (sausages.isSelected()){
            order.addTopping(Topping.SAUSAGE);
        }
        if(pineapples.isSelected()){
            order.addTopping(Topping.PINEAPPLE);
        }
        if(mushrooms.isSelected()){
            order.addTopping(Topping.MUSHROOMS);
        }
        if(pepperonis.isSelected()){
            order.addTopping(Topping.PEPPERONI);
        }
        if(onions.isSelected()){
            order.addTopping(Topping.ONION);
        }
        //Drinks
        if(pepsi.isSelected()){
            order.setDrink(Drink.PEPSI);
        } else if (sevenUp.isSelected()) {
            order.setDrink(Drink.SEVEN_UP);
        } else if(miranda.isSelected()){
            order.setDrink(Drink.MIRANDA);
        } else if(energyDrink.isSelected()){
            order.setDrink(Drink.ENERGY);
        } else if (iceTea.isSelected()) {
            order.setDrink(Drink.ICE_TEA);
        } else {
            order.setDrink(Drink.JUICE);
        }
        //Dips
        if(bbq.isSelected()){
            order.setDipping(Dipping.BBQ);
        } else if (ranch.isSelected()) {
            order.setDipping(Dipping.RANCH);
        } else if (marinara.isSelected()) {
            order.setDipping(Dipping.MARINARA);
        } else if (ketchup.isSelected()) {
            order.setDipping(Dipping.KETCHUP);
        } else if (garlic.isSelected()) {
            order.setDipping(Dipping.GARLIC);
        } else {
            order.setDipping(Dipping.BUFFALO);
        }
        //Setting Numbers
        order.setPizzaNum(pizzaCount);
        order.setDippingNum(dipsCount);
        order.setDrinkNum(drinksCount);
        orderText = order.orderText();
        receipt.appendText(orderText);
        double orderCost = order.calculateOrderCost();
        totalCost += orderCost;
        String formattedCost = String.format("%.2f",orderCost);
        receipt.appendText("\t\t\tTotal: $"+formattedCost+"\n===============\n");
    }

    @FXML
    void onConfirmClicked(MouseEvent event) throws Exception{
        try {
            // Load the new FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/pizzalabapp/views/payment-view.fxml"));
            AnchorPane newViewRoot = fxmlLoader.load();

            // Sending total Cost to PaymentController
            PaymentController paymentController = fxmlLoader.getController();
            paymentController.setTotalCost(totalCost);

            // Create a new scene for the new view
            Scene newViewScene = new Scene(newViewRoot);

            // Create a new stage for the new view
            Stage newViewStage = new Stage();
            newViewStage.setScene(newViewScene);
            newViewStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClearClicked(MouseEvent event){
        totalCost = 0;
        receipt.setText("");
    }

    @FXML
    void onExitClicked(MouseEvent event){
        System.exit(0);
    }

}
