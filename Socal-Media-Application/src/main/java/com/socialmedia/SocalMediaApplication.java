package com.socialmedia;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class SocalMediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocalMediaApplication.class, args);
		System.out.println("Social Media Appliction is Start Running..!!");
	}

	
	
	  @Bean
	    public ModelMapper modelMapper() {
		return new ModelMapper();
		
	}
}
