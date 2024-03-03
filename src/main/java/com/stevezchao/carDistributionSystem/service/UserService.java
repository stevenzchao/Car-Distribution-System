package com.stevezchao.carDistributionSystem.service;

import com.stevezchao.carDistributionSystem.pojo.User;

public interface UserService {
    void saveUser(User user);

    User getUser(String id);
}