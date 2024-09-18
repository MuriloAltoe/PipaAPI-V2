package com.example.pipa_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class PipaApiApplication {
	
	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure()
							 .ignoreIfMissing()
							 .load();
	
		dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
		
		SpringApplication.run(PipaApiApplication.class, args);
	}

}
