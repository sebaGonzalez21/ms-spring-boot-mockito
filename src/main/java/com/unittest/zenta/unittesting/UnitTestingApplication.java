package com.unittest.zenta.unittesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.unittest.zenta.unittesting")
public class UnitTestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnitTestingApplication.class, args);
	}

}
