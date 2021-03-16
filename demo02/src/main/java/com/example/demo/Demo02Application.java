package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.controller",
	"com.example.security",
	"com.example.aop"})
@MapperScan({"com.example.mapper"})
public class Demo02Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo02Application.class, args);
	}

}
