package com.example.wishlistrestapi.user.controller;

import com.example.wishlistrestapi.user.model.User;
import com.example.wishlistrestapi.user.model.UserList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user-api")
public class UserController {

    @GetMapping("/get-names")
    public String getUserNames(UserList userList) {
        return Arrays.stream(userList.getUsers())
                .map(User::getName)
                .collect(Collectors.joining(","));
    }
}
