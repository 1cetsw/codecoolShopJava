package com.codecool.shop.loginSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class retWebData
 */
@WebServlet("/menuregister")
public class MenuRegister extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        try {


            Connection con = DatabaseConnection.initializeDatabase();
            con.close();
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}