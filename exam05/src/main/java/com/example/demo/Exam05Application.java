package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.example.repository"})
@EntityScan({"com.example.entity"})
@ComponentScan({"com.example.controller"})
@SpringBootApplication
public class Exam05Application {

	public static void main(String[] args) {
		System.out.println("==========STRING BOOT START==========");
		SpringApplication.run(Exam05Application.class, args);
	}

}
