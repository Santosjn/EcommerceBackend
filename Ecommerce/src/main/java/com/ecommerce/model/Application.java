package com.ecommerce.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.ecommerce.controller" })
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("APP Running !!!");
	}

}
