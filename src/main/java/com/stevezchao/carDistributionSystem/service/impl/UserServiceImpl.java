package com.stevezchao.carDistributionSystem.service.impl;

import com.stevezchao.carDistributionSystem.pojo.User;
import com.stevezchao.carDistributionSystem.repo.UserRepository;
import com.stevezchao.carDistributionSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUser(String id) {
        return userRepository.findById(id).orElse(null);
    }

}