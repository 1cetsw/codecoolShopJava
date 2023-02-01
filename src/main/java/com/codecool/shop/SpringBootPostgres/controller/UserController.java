package com.codecool.shop.SpringBootPostgres.controller;

import com.codecool.shop.SpringBootPostgres.entity.User;
import com.codecool.shop.SpringBootPostgres.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository repo;

    @GetMapping("/home")
    public String homePage(Model model){
        model.addAttribute("user", new User());
        return "home";
    }

    @PostMapping("/save")
    public String saveUser(User user) {
        repo.save(user);

        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}