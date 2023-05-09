package com.example.pizzalabapp.controllers;

import com.example.pizzalabapp.models.DatabaseModel;
import com.example.pizzalabapp.models.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class RegistrationController {
    @FXML
    Label error;
    @FXML
    TextField emailTextField, nameTextField;
    @FXML
    PasswordField firstPassTextField, secondPassTextField;
    @FXML
    Button registerBtn;
    @FXML
    Hyperlink backHyperLink;

    @FXML
    void onRegisterClicked(MouseEvent event){
        error.setText("Testing");
        try{
            final String email = emailTextField.getText();
            final String pass1 = firstPassTextField.getText();
            final String pass2 = secondPassTextField.getText();
            final String name = nameTextField.getText();
            DatabaseModel db = DatabaseModel.getInstance();

            if(email.isEmpty() || pass1.isEmpty() || pass2.isEmpty() || name.isEmpty()){
                error.setText("Can't leave empty fields!!");
                return;
            }

            if (isValidEmail(email)) {
                if (pass1.equals(pass2)) {
                    if (isValidPassword(pass1)) {
                        if(!name.isEmpty()){
                            User user = new User(name, email, pass1);
                            db.addUser(user);
                            backToLogin();
                        }else{
                            error.setText("You can't leave the name field empty");
                        }
                    }else{
                        error.setText("Enter a valid password!");
                    }
                }else{
                    error.setText("Passwords doesn't match!");
                }
            }else{
                error.setText("Enter a valid email!");
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
            error.setText("Something went wrong "+e.getMessage());
        }
    }

    public static boolean isValidEmail(String email) {
        // Regular expression pattern for email validation
        String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        // Check if the email matches the pattern
        return email.matches(emailPattern);
    }

    public static boolean isValidPassword(String password) {
        // Password validation rules:
        // - at least 8 characters long
        // - contains at least one uppercase letter
        // - contains at least one lowercase letter

        // Regular expression pattern for password validation
        String passwordPattern = ".{8,}";

        // Check if the password matches the pattern
        return password.matches(passwordPattern);
    }

    @FXML
    void onBackBtnClicked(MouseEvent event){
        backToLogin();
    }

    void backToLogin(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/pizzalabapp/views/login-view.fxml"));
            Parent root = loader.load();
            Scene scene = backHyperLink.getScene();
            scene.setRoot(root);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
