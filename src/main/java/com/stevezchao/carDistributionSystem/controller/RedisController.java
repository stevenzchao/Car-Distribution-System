package com.stevezchao.carDistributionSystem.controller;

import com.stevezchao.carDistributionSystem.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis/operations")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @PostMapping("/{key}")
    public String setValue(@PathVariable String key, @RequestBody String value) {
        redisService.setValue(key, value);
        return "Done!!!";
    }

    @GetMapping("/{key}")
    public Object getValue(@PathVariable String key) {
        return redisService.getValue(key);
    }
}