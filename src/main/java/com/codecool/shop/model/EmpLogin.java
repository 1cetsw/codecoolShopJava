package com.codecool.shop.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

public class EmpLogin implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}