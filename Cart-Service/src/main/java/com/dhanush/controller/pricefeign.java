package com.dhanush.controller;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient (url= "http://localhost:2222" ,name="Price-Service")
@RibbonClient ("Price-Service")
public interface pricefeign {

	@GetMapping ("/api/price/{id}")
	public Double getPriceById(@PathVariable ("id") int id);
	
}
