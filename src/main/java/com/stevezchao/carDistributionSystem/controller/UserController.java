package com.stevezchao.carDistributionSystem.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stevezchao.carDistributionSystem.annotation.LogExecutionTime;
import com.stevezchao.carDistributionSystem.Entity.User;
import com.stevezchao.carDistributionSystem.pojo.randomapi.res.Location;
import com.stevezchao.carDistributionSystem.pojo.randomapi.res.Result;
import com.stevezchao.carDistributionSystem.pojo.randomapi.res.UserResponse;
import com.stevezchao.carDistributionSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/", consumes = "application/json")
    public String create(@RequestBody User user) {
        userService.saveUser(user);
        return "Done !!!";
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @LogExecutionTime(value= "test")
    public User retrieve(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    @PostMapping(value = "/getOneUserFromRandomAPI")
    public String getOneUserFromRandomAPI() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        String json = restTemplate.getForObject("https://randomuser.me/api/", String.class);
        ObjectMapper mapper = new ObjectMapper();
        System.err.println("here I AM");
        System.err.println(json);
        UserResponse userResponse = mapper.readValue(json, UserResponse.class);
        User user = new User();
        Result rs = userResponse.getResults().get(0);
        user.setGender(userResponse.getResults().get(0).getGender());
        user.setName(userResponse.getResults().get(0).getName().getFirst());
        user.setAge(userResponse.getResults().get(0).getDob().getAge());
        Location location = userResponse.getResults().get(0).getLocation();
        user.setAddress(location.getCountry() + location.getState() + location.getCity() +
                location.getStreet().getNumber() + location.getStreet().getName());
        user.setUserPicUrl(rs.getPicture().getMedium());
        user.setRegisteredTime(rs.getRegistered().getDate());
        userService.saveUser(user);

        System.err.println(userResponse);

        return "Done !!!";
    }

    @PostMapping(value = "/getAllUsersData", produces = "application/json")
    @Cacheable(cacheNames = "cache1", key = "'user'")
    public List<User> getAllUsersData() {
        return userService.getAllUsers();
    }
}