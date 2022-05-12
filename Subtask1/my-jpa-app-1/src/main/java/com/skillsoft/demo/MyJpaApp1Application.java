package com.skillsoft.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MyJpaApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(MyJpaApp1Application.class, args);
	}

}
