package com.restaurent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.restaurent")
public class RestaurentApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurentApplication.class, args);
	}
}
