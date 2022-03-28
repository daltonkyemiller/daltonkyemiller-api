 package com.daltonkyemiller.daltonkyemillerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;


@SpringBootApplication
@EnableMongoAuditing
public class DaltonkyemillerApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(DaltonkyemillerApiApplication.class, args);
	}
}
