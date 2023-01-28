package com.codecool.shop.dao.implementation.jdbc;

import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.DatabaseConnection;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDaoJDBC extends DatabaseConnection implements SupplierDao {
    private static SupplierDaoJDBC instance;

    public static SupplierDaoJDBC getInstance() {
        if (instance == null) {
            instance = new SupplierDaoJDBC();
        }
        return instance;
    }

    @Override
    public void add(Supplier supplier) {

    }

    @Override
    public Supplier find(int id) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = """
                        SELECT name, description, id FROM supplier WHERE id = ?""";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
            String name = rs.getString(1);
            String description = rs.getString(2);
            Supplier supplier = new Supplier(name, description);
            supplier.setId(rs.getInt(3));
            return supplier;
        } catch (SQLException e) {
            throw new RuntimeException("Error while reading supplier with id: " + id, e);
        }
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Supplier> getAll() {
        List<Supplier> result = new ArrayList<>();
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT name, description, id FROM supplier ORDER BY id";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                Supplier supplier = new Supplier(rs.getString(1),
                        rs.getString(2));
                supplier.setId(rs.getInt(3));
                result.add(supplier);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while reading all products: " + e);
        }
        return result;
    }
}