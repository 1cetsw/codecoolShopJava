package com.codecool.shop.dao.implementation.mem;

import com.codecool.shop.dao.UserCartDao;
import com.codecool.shop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class UserCartDaoImpl implements UserCartDao {
    private final String user;
    private final int userId;
    List<Product> shopingList;

    public UserCartDaoImpl(String user, int userId) {
        this.user = user;
        this.userId = userId;
        this.shopingList = new ArrayList<>();
    }
    public UserCartDaoImpl(String user, int userId, List<Product> shopingList) {
        this.user = user;
        this.userId = userId;
        this.shopingList = shopingList;
    }

    @Override
    public void addProduct(Product product) {
        shopingList.add(product);

    }

    @Override
    public List<Product> getAllProducts() {
        return shopingList;
    }

    @Override
    public void deleteProduct(int id) {
        shopingList.remove(id);

    }
}
