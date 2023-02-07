package com.codecool.shop.controller;

import com.codecool.shop.dao.implementation.DatabaseConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Serial;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/logout")
public class EmpLogoutServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseConnection.class);
    @Serial
    private static final long serialVersionUID = 1L;

    public EmpLogoutServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("username");
//            session.clear();
            RequestDispatcher dispatcher = request.getRequestDispatcher("emp-logout-success.jsp");
            logger.info("USER LOGOUT, SESSION CLEAR");
            dispatcher.forward(request, response);
        }
    }
}