package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.loginSystem.*;
import com.codecool.shop.dao.implementation.mem.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.mem.ProductDaoMem;
import com.codecool.shop.dao.implementation.mem.SupplierDaoMem;
import com.codecool.shop.loginSystem.MenuRegister;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import com.codecool.shop.service.ActiveDataSourceService;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.sql.SQLException;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ActiveDataSourceService activeDataSourceService = ActiveDataSourceService.getInstance();

        try {
            activeDataSourceService.getConfig();

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (activeDataSourceService.getUseMemDao()) {
            initializeMemDao();
        }
        try {
            activeDataSourceService.init();
        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }
    }

    private void initializeMemDao() {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        //setting up a new supplier
        Supplier supp1 = new Supplier("aaa", "opis aaa");
        Supplier supp2 = new Supplier("bbb", "opis bbbb");
        Supplier supp3 = new Supplier("ccc", "opis ccc");
        Supplier supp4 = new Supplier("ddd", "opis ddd");

        supplierDataStore.add(supp1);
        supplierDataStore.add(supp2);
        supplierDataStore.add(supp3);
        supplierDataStore.add(supp4);


        //setting up a new product category
        ProductCategory cat1 = new ProductCategory("a1", "abc", "opis a1");
        ProductCategory cat2 = new ProductCategory("a2", "abc", "opis a2");
        ProductCategory cat3 = new ProductCategory("a3", "abc", "opis a3");
        ProductCategory cat4 = new ProductCategory("a4", "abc", "opis a4");
        ProductCategory cat5= new ProductCategory("a5", "abc",
                "opis a5");
        ProductCategory cat6 = new ProductCategory("a6", "abc", "opis a6");
        productCategoryDataStore.add(cat1);
        productCategoryDataStore.add(cat2);
        productCategoryDataStore.add(cat3);
        productCategoryDataStore.add(cat4);
        productCategoryDataStore.add(cat5);
        productCategoryDataStore.add(cat6);


        //setting up products and printing it
        productDataStore.add(new Product("prod1", 50200, "USD", "opis", cat1, supp3));
        productDataStore.add(new Product("prod2", 1200, "USD", "opis", cat2, supp1));
        productDataStore.add(new Product("prod3", 475, "USD", "opis", cat3, supp1));
        productDataStore.add(new Product("prod4", 300, "USD", "opis", cat4, supp2));
        productDataStore.add(new Product("prod5", 350, "USD", "opis", cat5, supp3));

        productDataStore.add(new Product("prod6", 8500, "USD",
                "opis", cat6, supp3));
        productDataStore.add(new Product("prod7", 4500, "USD",
                "opis",
                cat2, supp4));
        productDataStore.add(new Product("prod8", 2000, "USD",
                "opis", cat1, supp1));
        productDataStore.add(new Product("prod8", 4080, "USD",
                "opis",
                cat6, supp1));
        productDataStore.add(new Product("prod9", 4280, "USD",
                "opis",
                cat4, supp3));


    }


}