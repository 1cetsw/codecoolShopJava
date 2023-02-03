package com.codecool.shop.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/logout")
public class EmpLogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EmpLogoutServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("username");

            RequestDispatcher dispatcher = request.getRequestDispatcher("emp-logout-success.jsp");
            dispatcher.forward(request, response);
        }
    }
}