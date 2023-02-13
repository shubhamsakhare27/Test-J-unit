package com.TestExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@SpringBootApplication
public class TestExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestExampleApplication.class, args);
	}
	
	  @Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }

}
