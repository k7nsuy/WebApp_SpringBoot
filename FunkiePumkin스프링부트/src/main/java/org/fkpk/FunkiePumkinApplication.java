package org.fkpk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "org.fkpk.mapper")
public class FunkiePumkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(FunkiePumkinApplication.class, args);
	}

}
