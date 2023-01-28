package com.codecool.shop.dao.implementation;

import javax.sql.DataSource;
import java.sql.SQLException;
import org.postgresql.ds.PGSimpleDataSource;

public abstract class DatabaseConnection {
    protected DataSource dataSource;

    public void connect(String dbName, String user, String password) throws SQLException {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();

        dataSource.setDatabaseName(dbName);
        dataSource.setUser(user);
        dataSource.setPassword(password);

        System.out.println("Trying to connect");
        dataSource.getConnection().close();
        System.out.println("Connection ok.");

        this.dataSource = dataSource;
    }
}