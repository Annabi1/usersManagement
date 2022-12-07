package com.fithnitek.UserManagement.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationCodeGrant;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.service.TokenEndpoint;
import springfox.documentation.service.TokenRequestEndpoint;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration

@EnableSwagger2
@EnableWebMvc
public class Swagger2Config {
	
	@Value("${info.app.name}")
	private String serviceName;
	
	@Value("${info.app.desc}")
	private String serviceDesc;
	
	@Value("${info.app.contact.name}")
	private String contactName;
	
	
	
	@Value("${info.app.contact.email}")
	private String contactEmail;
	
	@Value("${info.app.license}")
	private String license;
	
	@Value("${info.app.license-url}")
	private String licenseUrl;
	
	@Value("${info.app.version}")
	private String version;


	  
	    @Bean
	    public Docket buildApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .paths(regex("/api.*"))
	                .apis(RequestHandlerSelectors.any())
	                .paths(PathSelectors.any())
	                .build()
//	                .securitySchemes(Collections.singletonList(oauth()))
	                .apiInfo(apiEndPointsInfo());
	    }
	  

	   private ApiInfo apiEndPointsInfo() {
	        return new ApiInfoBuilder()
	        		.title(serviceName)
	                .description(serviceDesc)
	                .contact(new Contact(contactName, 
	                		contactEmail, contactEmail))
	                .license(license)
	                .licenseUrl(licenseUrl)
	                .version(version)
	                .build();
	    }

	 

}
