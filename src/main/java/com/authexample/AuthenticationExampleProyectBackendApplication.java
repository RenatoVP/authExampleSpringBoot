package com.authexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources(value = { @PropertySource("file:src/main/resources/application.properties") })
public class AuthenticationExampleProyectBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationExampleProyectBackendApplication.class, args);
	}

}
