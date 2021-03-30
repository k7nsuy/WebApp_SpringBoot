package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.example.repository"})
@EntityScan({"com.example.entity"})
@ComponentScan({"com.example.controller",
"com.example.security"})
@SpringBootApplication
public class Project01Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Project01Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Project01Application.class);
	}
}
