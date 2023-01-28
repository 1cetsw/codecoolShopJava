//package com.codecool.shop.dao.implementation;
//
//import com.codecool.shop.dao.UserDao;
//import com.codecool.shop.model.User;
//import lombok.AccessLevel;
//import lombok.Builder;
//import lombok.NoArgsConstructor;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//
//@NoArgsConstructor(access = AccessLevel.PRIVATE)
//public class UserDaoMem implements UserDao {
//
//    private List<User> userList  = new ArrayList<>();
//    private static UserDaoMem instance = null;
//    public static UserDaoMem getInstance() {
//        if (instance == null) {
//            instance = new UserDaoMem();
//        }
//        return instance;
//    }
//
//
//    @Override
//    public Optional<User> getUserById(int id) {
//        return userList.stream().filter(u -> u.getUserId() == id).findFirst();
//
//    }
//
//    @Override
//    public Optional<User> getUserByEmail(String email) {
//        return userList.stream().filter(u -> u.getEmail().equalsIgnoreCase(email)).findFirst();
//    }
//
//    @Override
//    public Optional<User> getUserByLogin(String login) {
//        return userList.stream().filter(u -> u.getUserLogin().equalsIgnoreCase(login)).findFirst();
//    }
//
//    @Override
//    public void addUser(User user) {
//        userList.add(user);
//    }
//}
