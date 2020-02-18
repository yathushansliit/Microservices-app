package com.kayal.employeejpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EmployeejpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeejpaApplication.class, args);
	}

	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
