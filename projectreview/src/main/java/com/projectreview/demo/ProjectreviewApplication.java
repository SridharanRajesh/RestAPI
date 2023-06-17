package com.projectreview.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;


@SpringBootApplication
@OpenAPIDefinition(info=@Info(

		title="Top10Songs",

		version="1.1.2",

		description="Artists",

		contact=@Contact(name="Subhashini",email="727821tuec232@skct.edu.in")))
public class ProjectreviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectreviewApplication.class, args);
	}

}
