package com.wtw.championship.config;
import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.wtw.championship.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo())
				;
	}

	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"Wheel To Wheel Championship API",
				"Wheel To Wheel Championship API reference for developers",
				"1.0",
				"http://wtwchampionship.com/terms",
				new Contact("Cabidoom", "https://steamcommunity.com/id/catalindumitrache76", "catalindumitrache76@gmail.com"),
				"LICENSE",
				"LICENSE URL",
				Collections.emptyList()
		);
	}
}