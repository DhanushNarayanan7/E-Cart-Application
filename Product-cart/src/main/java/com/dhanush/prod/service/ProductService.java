package com.dhanush.prod.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.dhanush.prod.dao.productdao;
import com.dhanush.prod.model.Product;
import com.dhanush.prod.model.Review;

@Service
public class ProductService {

	@Autowired
	private productdao pd;

	public List<Product> findall() {
		return pd.findAll();
	}

	public Product getProductById(int id) {
		return pd.findById(id).get();
	}

	public List<Product> findByContaining(String name) {
		return pd.findByContaining(name);
	}

	public Product saveProduct(Product prod) {
		return pd.save(prod);
	}

	public List<Product> saveallProducts(List<Product> prod) {
		return (List<Product>) pd.saveAll(prod);
	}

	//public List<Review> findReviewByProduct(int id) {
		//Optional<Product> prod = pd.findById(id);
		//return prod.get().getReview();
	//}
	
	
	public Double getPriceById(int id) {
		// pd.findPriceById(id);
		Optional<Product> prd=pd.findById(id);
		Product prod=prd.get();
		return prod.getPrice();
	}
}
