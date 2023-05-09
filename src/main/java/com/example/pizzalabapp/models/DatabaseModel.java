package com.example.pizzalabapp.models;

import java.sql.*;


public class DatabaseModel {
    private static final String dbUrl = "jdbc:mysql://localhost:3306/PizzaLab";
    private static DatabaseModel db = null;
    final private Connection conn;

    private DatabaseModel() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String password = "";
        String user = "root";
        conn = DriverManager.getConnection(dbUrl, user, password);
    }

    //Singleton Design Pattern
    public static DatabaseModel getInstance() throws SQLException, ClassNotFoundException{
        if(db == null){
            db = new DatabaseModel();
        }
        return db;
    }

    public void addUser(User user){
        try{
            String sql = "INSERT INTO USERS (NAME,EMAIL,PASSWORD) VALUES (?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,user.getName());
            stmt.setString(2,user.getEmail());
            stmt.setString(3,user.getPassword());
            stmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String checkUser(String email){
        try{
            String query = "SELECT * FROM USERS WHERE EMAIL = (?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,email);
            ResultSet result = stmt.executeQuery();
            if(result.next()){
                return result.getString("password");
            }
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
