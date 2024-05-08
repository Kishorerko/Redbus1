package com.example.kishorerko.redbus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class RedbusApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedbusApplication.class, args);
	}

}
