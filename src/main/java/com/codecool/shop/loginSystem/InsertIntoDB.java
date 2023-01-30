package com.codecool.shop.loginSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/InsertIntoDB")
public class InsertIntoDB extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {


            Connection con = DatabaseConnection.initializeDatabase();
            System.out.println(request.getParameter("username"));
            System.out.println(request.getParameter("emailaddress"));
            System.out.println(request.getParameter("password"));

            PreparedStatement st = con.prepareStatement("insert into register (username,password,emailaddress) values(?,?,?)");

            st.setString(1, request.getParameter("username"));
            st.setString(2, request.getParameter("password"));
            st.setString(3, request.getParameter("emailaddress"));

            st.executeUpdate();
            // Close all the connections
            st.close();
            con.close();
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
            // Get a writer pointer
            // to display the successful result
            PrintWriter out = response.getWriter();
            out.println("<html><body><b>Successfully Inserted" + "</b></body></html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}