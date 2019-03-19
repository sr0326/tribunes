package com;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication

public class SpringBootStart {
 
	public static void main(String[] args) {
		SpringApplication.run(SpringBootStart.class, args);
	}
	
}
