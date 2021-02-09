package com.itcast.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.itcast.admin.mapper")
@SpringBootApplication
public class Boot05Web2Application {

	public static void main(String[] args) {
		SpringApplication.run(Boot05Web2Application.class, args);
	}

}
