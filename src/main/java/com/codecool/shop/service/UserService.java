package com.codecool.shop.service;

import com.codecool.shop.dao.UserDao;
import com.codecool.shop.model.User;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class UserService {

    private UserDao userDao;

    public Optional<User> validateUser(String loginInfo, String password) {

        Optional<User> user = userDao.getUserByLogin(loginInfo);

        if(user.isEmpty()) {
            user = userDao.getUserByEmail(loginInfo);
            if(user.isEmpty()) {
                return Optional.empty();
            }
        }

        boolean isPasswordValid = user.get().getUserPassword().equals(password);
        return isPasswordValid ? user : Optional.empty();
    }

}
