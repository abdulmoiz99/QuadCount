package com.example.quadcount.service;

import com.example.quadcount.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> findAll();
}
