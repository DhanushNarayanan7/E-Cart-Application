package com.dhanush;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dhanush.controller.pricefeign;
import com.dhanush.product.model.Item;
import com.dhanush.product.model.ItemLine;
import com.dhanush.product.repository.CarRepositoryImpl;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class CartServiceApplication {
	
	@Autowired
	private pricefeign pf;
	
	@GetMapping ("/api/price/{id}")
	public Double getPriceById(@PathVariable ("id") int id) {
		return pf.getPriceById(id);
	}

	public static void main(String[] args) {
		//ApplicationContext ac= 
		SpringApplication.run(CartServiceApplication.class, args);
		
		//CarRepositoryImpl cr = ac.getBean(CarRepositoryImpl.class);
		
		//Item i1=new Item(1, "Pen", 10000);
		//Item i2=new Item(2, "Mobile", 45000);
		
		//ItemLine il=new ItemLine(i2, 4);
		//cr.save("dhanush", il);
		
		//System.out.println("---- DOne ");
		
		
		//cr.findAll("praveen").forEach(itemLine->{
			//System.out.println(itemLine.getItem().getId());
			//System.out.println(itemLine.getItem().getName());
			//System.out.println(itemLine.getItem().getPrice());
			//System.out.println("------------------------------------");
			
		//});
		
		
		
		
	
		
		
		
	}

}
