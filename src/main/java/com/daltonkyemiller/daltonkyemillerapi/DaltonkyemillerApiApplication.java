 package com.daltonkyemiller.daltonkyemillerapi;



import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.config.EnableMongoAuditing;


@EnableEncryptableProperties
@SpringBootApplication
@EnableMongoAuditing
public class DaltonkyemillerApiApplication{
	 public static void main(String[] args) {
		SpringApplication.run(DaltonkyemillerApiApplication.class, args);
	}
 }
