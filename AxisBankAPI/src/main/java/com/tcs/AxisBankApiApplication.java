package com.tcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages="com.gis.feign")
public class AxisBankApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AxisBankApiApplication.class, args);
	}

}
