package com.stevezchao.carDistributionSystem.service;

import com.stevezchao.carDistributionSystem.Entity.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    User getUser(Integer id);

    List<User> getAllUsers();
}