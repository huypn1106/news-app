package com.deadk.awsproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.deadk.awsproject"})
public class AwsprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsprojectApplication.class, args);
	}
}
