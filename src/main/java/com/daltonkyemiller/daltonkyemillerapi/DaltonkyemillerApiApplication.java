 package com.daltonkyemiller.daltonkyemillerapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

 @SpringBootApplication
public class DaltonkyemillerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaltonkyemillerApiApplication.class, args);
	}
}
