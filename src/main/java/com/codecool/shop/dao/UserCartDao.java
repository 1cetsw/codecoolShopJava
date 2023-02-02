package com.codecool.shop.dao;

import com.codecool.shop.model.Product;

import java.util.ArrayList;
import java.util.List;

public interface UserCartDao {
    void addProduct(Product product);
    List<Product> getAllProducts();
    void deleteProduct(int id);


}
