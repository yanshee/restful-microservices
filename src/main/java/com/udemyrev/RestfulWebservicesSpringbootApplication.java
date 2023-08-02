package com.udemyrev;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(
			title="Spring Boot Rest-api documentation",
			description="Spring Boot REST API Documentation",
			version="v1.0",
			contact=@Contact(
					name="yanshee",
					email="yanshee@gmail.com"
					)
			),
		externalDocs=@ExternalDocumentation(
				description="Spring Boot User Management documentation",
				url="https://www.javaguides.net/user_management.html"
				)
		)
public class RestfulWebservicesSpringbootApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RestfulWebservicesSpringbootApplication.class, args);
	}

}
