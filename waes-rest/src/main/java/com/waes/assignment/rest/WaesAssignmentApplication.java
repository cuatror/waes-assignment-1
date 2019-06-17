package com.waes.assignment.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.waes.assignment"})
public class WaesAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(WaesAssignmentApplication.class, args);
	}

}
