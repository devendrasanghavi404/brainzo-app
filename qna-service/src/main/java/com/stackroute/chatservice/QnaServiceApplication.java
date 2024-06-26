package com.stackroute.chatservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableEurekaClient
@SpringBootApplication
@EnableMongoRepositories
public class QnaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QnaServiceApplication.class, args);
	}

}
