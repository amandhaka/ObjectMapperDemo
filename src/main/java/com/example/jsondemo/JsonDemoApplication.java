package com.example.jsondemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class JsonDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonDemoApplication.class, args);
	}

}
