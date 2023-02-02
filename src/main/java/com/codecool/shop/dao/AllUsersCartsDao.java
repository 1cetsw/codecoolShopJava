package com.codecool.shop.dao;

import com.codecool.shop.dao.implementation.mem.UserCartDaoImpl;

public interface AllUsersCartsDao {
    void addNewCart(UserCartDaoImpl userCart);
    void deleteUserCart(int id);
    UserCartDaoImpl getUserCart(int id);


}
