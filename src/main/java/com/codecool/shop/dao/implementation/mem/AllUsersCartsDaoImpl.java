package com.codecool.shop.dao.implementation.mem;

import com.codecool.shop.dao.AllUsersCartsDao;

import java.util.ArrayList;
import java.util.List;

public class AllUsersCartsDaoImpl implements AllUsersCartsDao {
    List<UserCartDaoImpl> usersCarts;

    public AllUsersCartsDaoImpl() {
        this.usersCarts = new ArrayList<UserCartDaoImpl>();
    }

    @Override
    public void addNewCart(UserCartDaoImpl userCart) {
        usersCarts.add(userCart);
    }

    @Override
    public void deleteUserCart(int id) {
        usersCarts.remove(id);

    }

    @Override
    public UserCartDaoImpl getUserCart(int id) {
        return usersCarts.get(id);
    }
}
