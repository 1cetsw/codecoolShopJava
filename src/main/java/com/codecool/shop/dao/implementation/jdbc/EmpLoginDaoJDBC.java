package com.codecool.shop.dao.implementation.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codecool.shop.dao.implementation.DatabaseConnection;
import com.codecool.shop.model.EmpLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmpLoginDaoJDBC {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseConnection.class);
    public boolean validate(EmpLogin empLogin) throws ClassNotFoundException {
        boolean status = false;

        Class.forName("org.postgresql.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/shop?useSSL=false", "postgres", "cipka");

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection
                     .prepareStatement("select * from employee where username = ? and password = ? ")) {
            preparedStatement.setString(1, empLogin.getUsername());
            preparedStatement.setString(2, empLogin.getPassword());
            logger.info("Login USER");
            logger.info(preparedStatement.toString());

            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();



        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return status;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);

                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    logger.info("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}