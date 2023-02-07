package com.codecool.shop.dao.implementation;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.postgresql.ds.PGSimpleDataSource;

public abstract class DatabaseConnection {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseConnection.class);
    protected DataSource dataSource;

    public void connect(String dbName, String user, String password) throws SQLException {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();

        dataSource.setDatabaseName(dbName);
        dataSource.setUser(user);
        dataSource.setPassword(password);

        logger.info("Trying to connect AutoPartsShop Database");
        dataSource.getConnection().close();
        logger.info("Successfully Connected");

        this.dataSource = dataSource;
    }

}