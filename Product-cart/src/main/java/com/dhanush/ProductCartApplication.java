package com.dhanush;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCartApplication.class, args);

	}

}
