package com.stevezchao.carDistributionSystem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class CarDistributionSystemApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	void writeTest() {
		redisTemplate.opsForValue().set("name", "jobs");

	}

	@Test
	void getTest() {
		Object name = redisTemplate.opsForValue().get("name");
		if (name != null) {
			System.out.println(name.toString());
		}

		Object lastname = redisTemplate.opsForValue().get("lastname");
		if (name != null) {
			System.out.println(lastname.toString());
		}
	}
}
