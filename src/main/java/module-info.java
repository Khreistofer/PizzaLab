module com.example.pizzalabapp {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.pizzalabapp to javafx.fxml;
    exports com.example.pizzalabapp;
    exports com.example.pizzalabapp.controllers;
    opens com.example.pizzalabapp.controllers to javafx.fxml;
}