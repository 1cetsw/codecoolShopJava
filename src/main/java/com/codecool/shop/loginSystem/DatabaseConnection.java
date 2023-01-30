package com.codecool.shop.loginSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// This class can be used to initialize the database connection
public class DatabaseConnection {
    private static DatabaseConnection instance;
    protected static Connection initializeDatabase()
            throws SQLException, ClassNotFoundException
    {
        // Initialize all the information regarding
        // Database Connection
        System.out.println("connection to login system");
        Class.forName("org.postgresql.Driver");

        Connection con =DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop","1ce", "cipka");
        return con;
    }


    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}