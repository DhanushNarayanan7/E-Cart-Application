package com.dhanush.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.dhanush.service.priceservice;

@RestController
public class PriceController {
	
	@Autowired
	private priceservice priceservice;
	
	
	@GetMapping ("/api/price/{id}")
	public Double getPriceById(@PathVariable int id) {
		return priceservice.findPriceById(id);
	}

}
