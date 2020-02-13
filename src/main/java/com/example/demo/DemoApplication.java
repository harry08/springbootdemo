package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Entry point for the Spring Boot application.
 * The extension of SpringBootServletInitializer is only needed
 * when the application should be deployed as a war to a web server.
 */
@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer
{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}

	public static void main(String[] args)
	{
		SpringApplication.run(DemoApplication.class, args);
	}
}