package com.Spring.SimpleSwagger.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	@Value("${spring.application.name}")
	private String appName;
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/**"))
//				.apis(RequestHandlerSelectors.basePackage("com.Spring.SimpleSwagger.controller"))
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.build()
				.apiInfo(swaggerDetails());
	}
	
	private ApiInfo swaggerDetails() {
		return new ApiInfo(
				appName,
//				"User-Service Documentation",
				"This is the documentation for " + appName + " Microservice",
				"1.0",
				"Only for Documentation and Testing",
				new springfox.documentation.service.Contact(null, null, null),
//				new springfox.documentation.service.Contact("LogiNext", "https://www.loginextsolutions.com/", ""),
				"LogiNext license",
				null,
//				"https://www.loginextsolutions.com/",
				Collections.emptyList()
		);
	}

}
