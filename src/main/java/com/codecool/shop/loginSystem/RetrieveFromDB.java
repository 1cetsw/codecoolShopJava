package com.codecool.shop.loginSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class retWebData
 */
@WebServlet("/RetrieveFromDB")
public class RetrieveFromDB extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            //Connection con = DatabaseConnection.initializeDatabase();
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop", "postgres", "cipka");
            con.setAutoCommit(false);

            PrintWriter out = response.getWriter();
            String emailaddress = request.getParameter("emailaddress");
            String password = request.getParameter("password");
            System.out.println(request.getParameter("emailaddress"));
            System.out.println(request.getParameter("password"));


            Statement stmt = null;
            stmt = con.createStatement();
            int n = 0;


            ResultSet rs = stmt.executeQuery(" select password,emailaddress from users where emailaddress='" + emailaddress + "' and password='" + password + "'");
            while (rs.next()) {
                String email = rs.getString("emailaddress");
                String pass = rs.getString("password");
                System.out.println(email);
                System.out.println(pass);

                if ((email.equals(emailaddress)) && (pass.equals(password))) {//out.print("Welcome," +d_email );
                    request.getRequestDispatcher("/Welcome.jsp").include(request, response);
                    //response.sendRedirect("createnoti.jsp");

                    HttpSession session = request.getSession();
                    session.setAttribute("emailaddress", emailaddress);
                    n = 1;
                    break;
                }


            }

            if (n == 0) {
                out.print("Sorry! user name or password incorrect.");
            }

            out.close();
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ";" + e.getMessage());
            System.exit(0);
        }

    }
}
