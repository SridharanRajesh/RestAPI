package com.ipl.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(
				title="PRO KABADDI",
				version="1.1.2",
				description="PRO KABADDI DETAILS",
				contact=@Contact(
						name="SRIDHARAN",
						email="r.sridharanrajesh@gmail.com"
						)
				)	
		)
public class IplApplication {

	public static void main(String[] args) {
		SpringApplication.run(IplApplication.class, args);
	}

}
