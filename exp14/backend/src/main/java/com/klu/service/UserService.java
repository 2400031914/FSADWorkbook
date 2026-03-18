package com.klu.service;

import com.klu.model.User;

public interface UserService {
    User register(User user);
    User login(String username, String password);
    User getUserById(int id);
}