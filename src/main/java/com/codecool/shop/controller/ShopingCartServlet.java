package com.codecool.shop.controller;

import com.codecool.shop.config.Initializer;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.UserCartDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.service.ActiveDataSourceService;
import com.codecool.shop.service.ProductService;
import org.thymeleaf.context.WebContext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ShopingCartServlet", value = "/cart")
public class ShopingCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebContext context = new WebContext(request, response, request.getServletContext());
        if(request.getParameter("productId") != null){
            int productId = Integer.parseInt(request.getParameter("productId"));
            ActiveDataSourceService activeDataSourceService = ActiveDataSourceService.getInstance();
            ProductDao productDataStore = activeDataSourceService.getActiveProductDao();
            ProductCategoryDao productCategoryDataStore = activeDataSourceService.getActiveProductCategoryDao();
            ProductService productService = new ProductService(productDataStore, productCategoryDataStore);
            Product prod = productService.getProduct(productId);
            Initializer.usersCarts.getUserCart(0).addProduct(prod);

        }
        context.setVariable("shopingList",  Initializer.usersCarts.getUserCart(0).getAllProducts());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
