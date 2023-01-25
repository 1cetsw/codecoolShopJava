package com.codecool.shop.model;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@Builder
public class User {
    private int userId;
    private String userLogin;
    private String userPassword;
    private String email;
    private String userFullName;
}
