package com.dhanush.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.dhanush.product.model.Item;
import com.dhanush.product.model.ItemLine;
//import com.dhanush.product.model.ItemTotal;
import com.dhanush.product.repository.CarRepositoryImpl;


@RestController
public class cartcontroller {
	

	@Autowired
	private CarRepositoryImpl cart;

	@Autowired
	private pricefeign pf;
	
	@PostMapping(value="/api/cart/dhanush", produces="application/json")
	public ItemLine saveCart(@RequestBody ItemLine itemline) {
		Double feignprice=pf.getPriceById(itemline.getItem().getId());
		itemline.getItem().setPrice(feignprice);
		//System.out.println("price:" +itemline.getItem().getPrice());
		//System.out.println("qty:" +itemline.getQty());
		//if(itemline.getItem().getItemtotal()==null) {
		double tot=itemline.getItem().getPrice()*itemline.getQty();
		//System.out.println("tot:" +tot);
		itemline.getItem().setItemtotal(tot);		
		ItemLine itl=new ItemLine(itemline.getItem(),itemline.getQty());
		cart.save("dhanush", itl);
		return itl;
	}
	
	
}
