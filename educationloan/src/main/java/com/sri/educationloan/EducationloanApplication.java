package com.sri.educationloan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(
				title="BANKING",
				version="1.1.2",
				description="Educational Loans",
				contact=@Contact(
						name="Sridharan",
						email="r.sridharanrajesh@gmail.com"
						)
				)	
		)
public class EducationloanApplication {

	public static void main(String[] args) {
		SpringApplication.run(EducationloanApplication.class, args);
	}

}
