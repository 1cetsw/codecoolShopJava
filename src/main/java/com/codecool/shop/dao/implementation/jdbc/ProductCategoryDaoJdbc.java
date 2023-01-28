package com.codecool.shop.dao.implementation.jdbc;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.implementation.DatabaseConnection;
import com.codecool.shop.model.ProductCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryDaoJDBC extends DatabaseConnection implements ProductCategoryDao {
    private static ProductCategoryDaoJDBC instance;

    public static ProductCategoryDaoJDBC getInstance() {
        if (instance == null) {
            instance = new ProductCategoryDaoJDBC();
        }
        return instance;
    }

    @Override
    public void add(ProductCategory category) {

    }

    @Override
    public ProductCategory find(int id) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT name, department, description, id FROM product_category WHERE id = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
            String name = rs.getString(1);
            String department = rs.getString(2);
            String description = rs.getString(3);
            ProductCategory productCategory = new ProductCategory(name,department, description);
            productCategory.setId(rs.getInt(4));
            return productCategory;
        } catch (SQLException e) {
            throw new RuntimeException("Error while reading productCategory with id: " + id, e);
        }
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<ProductCategory> getAll() {
        List<ProductCategory> result = new ArrayList<>();
        try (Connection conn = dataSource.getConnection()) {
            String sql = """
                        SELECT name, department, description, id
                        FROM product_category ORDER BY id""";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                ProductCategory productCategory = new ProductCategory(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3));
                productCategory.setId(rs.getInt(4));
                result.add(productCategory);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while reading all products: " + e);
        }
        return result;
    }
}