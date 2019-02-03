package com.sony;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.sony.repository.BaseMongoRepositoryImpl;

@SpringBootApplication
@EnableMongoRepositories(repositoryBaseClass = BaseMongoRepositoryImpl.class)
@ComponentScan(value = "com.sony")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
