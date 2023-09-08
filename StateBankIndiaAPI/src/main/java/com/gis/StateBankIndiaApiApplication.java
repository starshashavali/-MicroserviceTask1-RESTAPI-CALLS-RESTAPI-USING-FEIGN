package com.gis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication

public class StateBankIndiaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StateBankIndiaApiApplication.class, args);
	}

}
