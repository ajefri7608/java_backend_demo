package com.example.java_backend_demo;

import com.example.java_backend_demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.persistence.EntityManagerFactory;

//EnableSwagger2
@SpringBootApplication
@Configuration
@ComponentScan("com.example")
public class JavaBackendDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaBackendDemoApplication.class, args);
	}


}
