package com.stevezchao.carDistributionSystem.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;


//@RedisHash("USERS")
@Entity
@Table(name = "USERS" )
@Getter
@Setter
public class User implements Serializable {

    @Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int age;
    private String gender;
    private String address;
    private String registeredTime;
    private String userPicUrl;





}