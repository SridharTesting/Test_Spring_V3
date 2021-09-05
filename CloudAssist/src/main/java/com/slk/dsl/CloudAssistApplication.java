package com.slk.dsl;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@SpringBootApplication
@Configuration

@EnableAutoConfiguration
@ComponentScan({"com.slk.dsl"})
public class CloudAssistApplication extends SpringBootServletInitializer{

	/*
	 * @Bean public Docket api() { // @formatter:off //Register the controllers to
	 * swagger //Also it is configuring the Swagger Docket return new
	 * Docket(DocumentationType.SWAGGER_2).select() //
	 * .apis(RequestHandlerSelectors.any())
	 * .apis(Predicates.not(RequestHandlerSelectors.basePackage(
	 * "org.springframework.boot"))) // .paths(PathSelectors.any()) //
	 * .paths(PathSelectors.ant("/swagger2-demo")) .build(); // @formatter:on }
	 */
	
	
    
	public static void main(String[] args) {
		SpringApplication.run(CloudAssistApplication.class, args);
	
	}
	
	

}
