package com.sri.bankdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(
				title="BANK DETAILS",
				version="1.1.2",
				description="Banking and Loans",
				contact=@Contact(
						name="SRIDHARAN R",
						email="r.sridharanrajesh@gmail.com"
						)
				)	
		)
public class BankdetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankdetailsApplication.class, args);
	}

}
