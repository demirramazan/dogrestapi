package com.udacity.dogrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class DogrestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogrestapiApplication.class, args);
	}

}
