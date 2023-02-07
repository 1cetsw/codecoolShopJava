package com.codecool.shop.controller;


import java.io.IOException;
import java.io.Serial;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codecool.shop.dao.implementation.DatabaseConnection;
import com.codecool.shop.model.EmpLogin;
import com.codecool.shop.dao.implementation.jdbc.EmpLoginDaoJDBC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebServlet("/login")
public class EmpLoginServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseConnection.class);
    @Serial
    private static final long serialVersionUID = 1L;
    private EmpLoginDaoJDBC loginDao;

    public void init() {
        loginDao = new EmpLoginDaoJDBC();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        EmpLogin empLogin = new EmpLogin();
        empLogin.setUsername(username);
        empLogin.setPassword(password);

        try {

            if (loginDao.validate(empLogin)) {
                HttpSession session = request.getSession();
                 session.setAttribute("username",username);
                logger.info("SUCCESS LOGIN USER: ",username);
                response.sendRedirect("emp-login-success.jsp");

            } else {
                HttpSession session = request.getSession();
                session.setAttribute("user", username);
                logger.error("DENIED ACCESS FOR USER: ",username);
                response.sendRedirect("emp-login-denied.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}