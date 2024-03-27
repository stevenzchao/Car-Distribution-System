package com.stevezchao.carDistributionSystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(scanBasePackages = "com.stevezchao.CarDistributionSystem")
@EnableAspectJAutoProxy
public class CarDistributionSystemApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(CarDistributionSystemApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CarDistributionSystemApplication.class, args);
	}

}
