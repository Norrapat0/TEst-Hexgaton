package com.history.history;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

// @SpringBootApplication
// @ComponentScan(basePackages = {"hom.login.RegisandLogin"})
@SpringBootApplication
@EntityScan(basePackages = {"freelance/service/freelanceservice"})
public class HistoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(HistoryApplication.class, args);
	}

}