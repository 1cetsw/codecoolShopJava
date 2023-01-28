//package com.codecool.shop.controller;
//
//
//import com.codecool.shop.config.TemplateEngineUtil;
//import com.codecool.shop.dao.implementation.UserDaoMem;
//import com.codecool.shop.model.User;
//import com.codecool.shop.service.UserService;
//import org.thymeleaf.TemplateEngine;
//import org.thymeleaf.context.WebContext;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Optional;
//
//
//@WebServlet("/login")
//public class LoginServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        boolean isLogged = (boolean) Optional.ofNullable(req.getSession(true).getAttribute("isLogged")).orElse(false);
//
//        if(isLogged) {
//            resp.sendRedirect("account/user");
//            return;
//        }
//
//        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
//        WebContext context = new WebContext(req, resp, req.getServletContext());
//        engine.process("login.html", context, resp.getWriter());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String userLogin = req.getParameter("userlogin");
//        String userPassword = req.getParameter("userpassword");
//
//        UserService userService = new UserService(UserDaoMem.getInstance());
//        Optional<User> user = userService.validateUser(userLogin, userPassword);
//
//        if(user.isPresent()) {
//            resp.setStatus(200);
//            req.getSession(true).setAttribute("isLogged", true);
//            req.getSession(true).setAttribute("userId", user.get().getUserId());
//            req.getSession(true).setAttribute("userFullName", user.get().getUserFullName());
//            resp.sendRedirect("account/user");
//        }
//    }
//
//
//}
