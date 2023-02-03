package com.codecool.shop.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codecool.shop.dao.implementation.jdbc.EmpRegisterDaoJDBC;
import com.codecool.shop.model.EmpRegister;


@WebServlet(name = "RegisterServlet", value = "/register")
public class EmpRegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmpRegisterDaoJDBC employeeDao;

    public void init() {
        employeeDao = new EmpRegisterDaoJDBC();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");

        EmpRegister employee = new EmpRegister();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setUsername(username);
        employee.setPassword(password);
        employee.setContact(contact);
        employee.setAddress(address);

        try {
            employeeDao.registerEmployee(employee);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("emp-register-success.jsp");
    }

}