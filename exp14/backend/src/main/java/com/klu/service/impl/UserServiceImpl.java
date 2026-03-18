package com.klu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.model.User;
import com.klu.repo.UserRepository;
import com.klu.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public User register(User user) {
        return repo.save(user);
    }

    @Override
    public User login(String username, String password) {
        User u = repo.findByUsername(username);
        if (u != null && u.getPassword().equals(password)) {
            return u;
        }
        return null;
    }

    @Override
    public User getUserById(int id) {
        return repo.findById(id).orElse(null);
    }
}