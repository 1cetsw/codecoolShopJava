package com.codecool.shop.dao;

import com.codecool.shop.model.Supplier;
import com.codecool.shop.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    Optional<User>  getUserById(int id);
    Optional<User> getUserByEmail(String email);
    Optional<User> getUserByLogin(String login);
    void addUser(User user);
}
