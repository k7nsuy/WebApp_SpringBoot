package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy // 추가
@ComponentScan({"com.example.controller","com.example.aop","com.example.restcontroller"}) //컨트롤러 패키지명
@MapperScan({"com.example.mapper"}) //mapper 패키지
//controller를 찾기 위해 componentscan 설정
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("SPRING BOOT START");
		SpringApplication.run(DemoApplication.class, args);
		//SPRING BOOT 구동
	}

}
