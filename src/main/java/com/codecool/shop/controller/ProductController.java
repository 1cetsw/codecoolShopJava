package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.service.ActiveDataSourceService;
import com.codecool.shop.service.ProductService;
import com.codecool.shop.service.SupplierService;
import lombok.extern.slf4j.Slf4j;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Slf4j
@WebServlet(urlPatterns = {"/", "/category"})
public class ProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ActiveDataSourceService activeDataSourceService = ActiveDataSourceService.getInstance();
        log.info("Connection to database");
        //DAO
        ProductDao productDataStore = activeDataSourceService.getActiveProductDao();
        SupplierDao supplierDataStore = activeDataSourceService.getActiveSupplierDao();
        ProductCategoryDao productCategoryDataStore = activeDataSourceService.getActiveProductCategoryDao();

        //Services

        ProductService productService = new ProductService(productDataStore, productCategoryDataStore);
        SupplierService supplierService = new SupplierService(supplierDataStore);
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());

        if ((req.getParameter("categoryId") != null) && (req.getParameter("vendorId") == null)) {
            int category_id = Integer.parseInt(req.getParameter("categoryId"));
            context.setVariable("supplier", null);
            context.setVariable("category", productService.getProductCategory(category_id));
            context.setVariable("products", productService.getProductsForCategory(category_id));

        } else if ((req.getParameter("categoryId") == null) && (req.getParameter("supplierId") != null)) {
            int supplierId = Integer.parseInt(req.getParameter("supplierId"));
            context.setVariable("category", null);

        } else {
            context.setVariable("supplier", null);
            context.setVariable("category", null);
            context.setVariable("products", productService.getAllProducts());

        }
        //display  category and suppliers in home page
        context.setVariable("allcategories", productCategoryDataStore.getAll());
        context.setVariable("allsuppliers", supplierService.getAllSuppliers());



        engine.process("product/index.html", context, resp.getWriter());
    }

}