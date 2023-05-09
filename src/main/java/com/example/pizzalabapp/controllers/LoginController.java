package com.example.pizzalabapp.controllers;

import com.example.pizzalabapp.PizzaLabApp;
import com.example.pizzalabapp.models.DatabaseModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class LoginController {
    @FXML
    private Button loginBtn;
    @FXML
    private Label error;
    @FXML
    private TextField emailTextField;
    @FXML
    private PasswordField passTextField;
    @FXML
    private Hyperlink registerNow;

    @FXML
    void onLoginBtnClicked(MouseEvent event){
        try{
            DatabaseModel db = DatabaseModel.getInstance();
            final String email = emailTextField.getText();
            final String password = passTextField.getText();
            if(email.isEmpty()){
                error.setText("Please enter your email!");
                return;
            }
            final String checkPass = db.checkUser(email);
            if(checkPass == null){
                error.setText("Email not found !");
                return;
            }
            if(!checkPass.equals(password)){
                error.setText("Incorrect password !");
                return;
            }
            FXMLLoader loader = new FXMLLoader(PizzaLabApp.class.getResource("/com/example/pizzalabapp/views/home-view.fxml"));
            Parent root = loader.load();
            Scene scene = loginBtn.getScene();
            scene.setRoot(root);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void onRegisterNowClicked(MouseEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(PizzaLabApp.class.getResource("/com/example/pizzalabapp/views/register-view.fxml"));
        Parent root = loader.load();
        Scene scene = registerNow.getScene();
        scene.setRoot(root);
    }

}