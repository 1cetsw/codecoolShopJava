package com.codecool.shop.service;


import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.jdbc.ProductCategoryDaoJDBC;
import com.codecool.shop.dao.implementation.jdbc.ProductDaoJDBC;
import com.codecool.shop.dao.implementation.jdbc.SupplierDaoJDBC;
import com.codecool.shop.dao.implementation.mem.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.mem.ProductDaoMem;
import com.codecool.shop.dao.implementation.mem.SupplierDaoMem;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public class ActiveDataSourceService {
    private static ActiveDataSourceService instance;
    private ProductDao activeProductDao;
    private SupplierDao activeSupplierDao;
    private ProductCategoryDao activeProductCategoryDao;
    private boolean useMemDao;
    private String user;
    private String url;
    private String database;
    private String password;



    public static ActiveDataSourceService getInstance() {
        if (instance == null) {
            instance = new ActiveDataSourceService();
        }
        return instance;
    }

    private ActiveDataSourceService() {
    }

    public void init() throws SQLException {
        if (useMemDao) {

            activeProductDao = ProductDaoMem.getInstance();
            activeSupplierDao = SupplierDaoMem.getInstance();
            activeProductCategoryDao = ProductCategoryDaoMem.getInstance();
        } else {

            ProductDaoJDBC.getInstance().connect(database, user, password);
            SupplierDaoJDBC.getInstance().connect(database, user, password);
            ProductCategoryDaoJDBC.getInstance().connect(database, user, password);

            activeProductDao = ProductDaoJDBC.getInstance();
            activeSupplierDao = SupplierDaoJDBC.getInstance();
            activeProductCategoryDao = ProductCategoryDaoJDBC.getInstance();
        }
    }

    public boolean getUseMemDao() {
        return useMemDao;
    }

    public ProductDao getActiveProductDao() {
        return activeProductDao;
    }

    public SupplierDao getActiveSupplierDao() {
        return activeSupplierDao;
    }

    public ProductCategoryDao getActiveProductCategoryDao() {
        return activeProductCategoryDao;
    }

    public void getConfig() throws IOException {
        InputStream inputStream = null;
        try {

            Properties prop = new Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            user = prop.getProperty("user");
            useMemDao = prop.getProperty("usememdao").equalsIgnoreCase("true");
            url = prop.getProperty("url");
            database = prop.getProperty("database");
            password = prop.getProperty("password");

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
    }
}