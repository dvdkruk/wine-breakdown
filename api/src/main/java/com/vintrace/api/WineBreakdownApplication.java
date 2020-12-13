package com.vintrace.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class WineBreakdownApplication {

	public static void main(String[] args) {
		SpringApplication.run(WineBreakdownApplication.class, args);
	}

}
