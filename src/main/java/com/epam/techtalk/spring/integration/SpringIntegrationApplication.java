package com.epam.techtalk.spring.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication
public class SpringIntegrationApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationApplication.class, args);
	}
}
