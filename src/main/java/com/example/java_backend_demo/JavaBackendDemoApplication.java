package com.example.java_backend_demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@Configuration
@ComponentScan("com.example")
public class JavaBackendDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaBackendDemoApplication.class, args);
	}


}
