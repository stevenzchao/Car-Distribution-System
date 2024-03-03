package com.stevezchao.carDistributionSystem.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("users")
@Getter
@Setter
public class User {

    @Id
    private String id;
    private String name;
    private int age;
}