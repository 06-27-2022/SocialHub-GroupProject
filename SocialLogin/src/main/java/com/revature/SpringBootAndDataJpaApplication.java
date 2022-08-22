package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;


@SpringBootApplication
public class SpringBootAndDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAndDataJpaApplication.class, args);
	}
	

	
//	@Bean
//	public RestTemplate restTemplate() {
//		RestTemplate restTemplate = new RestTemplate();
//
//		restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("https://pokeapi.co/api/v2/"));
//		return restTemplate;
//	}
//	
	

}
