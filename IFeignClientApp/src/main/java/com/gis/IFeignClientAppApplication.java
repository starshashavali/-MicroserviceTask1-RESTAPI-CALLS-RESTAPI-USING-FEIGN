package com.gis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class IFeignClientAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(IFeignClientAppApplication.class, args);
	}

}
