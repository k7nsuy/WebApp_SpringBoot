package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.example.controller"})
@EntityScan({"com.example.entity"})
@EnableJpaRepositories(basePackages = {"com.example.repository"})
public class Jpa01Application {

	public static void main(String[] args) {
		SpringApplication.run(Jpa01Application.class, args);
	}

}
