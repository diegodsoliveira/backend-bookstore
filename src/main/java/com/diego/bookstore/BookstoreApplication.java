package com.diego.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.diego.bookstore.model"})
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan(basePackages = {"com.*"})
public class BookstoreApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

}
