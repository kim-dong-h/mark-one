package com.dhkim.markone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dhkim.markone.controller","com.dhkim.markone.service", "com.dhkim.markone.config"})
public class MarkOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarkOneApplication.class, args);
	}

}
