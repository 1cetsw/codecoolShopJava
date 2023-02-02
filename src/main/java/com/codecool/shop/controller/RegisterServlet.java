package com.codecool.shop.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        try {

            // loading drivers for mysql
            Class.forName("org.postgresql.Driver");

            //creating connection with the database
            Connection con = DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/shop","postgres","cipka");

            PreparedStatement ps = con.prepareStatement
                    ("insert into users values(?,?,?)");

            ps.setString(1, name);
            ps.setString(3, email);
            ps.setString(2, pass);
            int i = ps.executeUpdate();

            if(i > 0) {
                out.println("You are successfully registered at Shop");
            }

        }
        catch(Exception se) {
            se.printStackTrace();
        }

    }
}