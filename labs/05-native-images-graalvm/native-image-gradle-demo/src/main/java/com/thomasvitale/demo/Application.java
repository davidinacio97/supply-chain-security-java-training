package com.thomasvitale.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	RouterFunction<ServerResponse> routerFunction() {
		return RouterFunctions.route()
			.GET("/", request -> ServerResponse.ok().body("Welcome to your development environment!"))
			.GET("/books", request -> ServerResponse.ok().body(List.of(
				new Book("The Hobbit"),
				new Book("The Lord of the Rings")
			)))
			.build();
	}


	record Book(String title) {
	}
}
