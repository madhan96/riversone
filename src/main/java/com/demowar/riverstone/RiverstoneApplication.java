package com.demowar.riverstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.demowar.riverstone.repository")
public class RiverstoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(RiverstoneApplication.class, args);
	}

}
