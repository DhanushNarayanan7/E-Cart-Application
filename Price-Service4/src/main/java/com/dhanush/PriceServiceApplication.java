package com.dhanush;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dhanush.controller.ProductFeign;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class PriceServiceApplication {

	@Autowired
	private  ProductFeign pf;
	
	@GetMapping ("/api/price/{id}")
	public Double getPriceById(@PathVariable ("id") int id) {
		return pf.getPriceById(id);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PriceServiceApplication.class, args);
	}

}
