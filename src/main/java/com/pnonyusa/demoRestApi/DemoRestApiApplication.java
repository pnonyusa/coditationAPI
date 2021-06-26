package com.pnonyusa.demoRestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRestApiApplication.class, args);
	}

	@Bean
    public SpringApplicationContext springApplicationContext(){
	    return new SpringApplicationContext();
    }
}
