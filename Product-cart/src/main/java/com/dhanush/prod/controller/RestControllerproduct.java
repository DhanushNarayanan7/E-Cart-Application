package com.dhanush.prod.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dhanush.prod.dao.productdao;
import com.dhanush.prod.dao.reviewdao;
import com.dhanush.prod.model.Product;
import com.dhanush.prod.model.Review;
import com.dhanush.prod.service.ProductService;
import com.dhanush.prod.service.ReviewService;

@RestController
public class RestControllerproduct {

	@Autowired
	private ProductService ps;

	@Autowired
	private ReviewService rs;

	@Autowired
	private productdao proddao;

	@Autowired
	private reviewdao revdao;

	@GetMapping("/api/products")
	public List<Product> findall() {
		return ps.findall();
	}

	@GetMapping("/api/products/{id}")
	public Product getProductById(@PathVariable int id) {

		return ps.getProductById(id);
	}

	@GetMapping("/api/products/byName/{name}")
	public List<Product> getProductByName(@PathVariable String name) {
		return ps.findByContaining(name);
	}

	@PostMapping(value = "/api/products", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Product saveProduct(@RequestBody Product prod) {
		return ps.saveProduct(prod);
	}

	@PostMapping(value = "/api/products/all", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<Product> saveAllProduct(@RequestBody List<Product> prod) {
		return ps.saveallProducts(prod);
	}

	// @GetMapping (value="/api/products/{id}/reviews",produces =
	// {MediaType.APPLICATION_JSON_VALUE} )
	// public List <Review> retrieveReview (@PathVariable("id") int id) {
	// prod.setId(id);
	// Optional <Product> pd = ps.findReviewByProduct(id);
	// return rs.findReviewByProduct(id);
//	}

	@GetMapping(path = "/api/products/{id}/reviews", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Review> getReview(@PathVariable(value = "id") int id) {
		return revdao.findByProductId(id);
	}

	@PostMapping(value = "/api/products/{id}/reviews", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Review saveReview(@PathVariable int id, @RequestBody Review rev) {
		Optional<Product> pd = proddao.findById(id);
		Product product = pd.get();
		rev.setProduct(pd.get());
		Review newrev = rs.saveReview(rev);
		return rs.addreview(id, rev);

	}
	
	//---------------------------------------------------/
	
	@GetMapping (path="/api/price/{id}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public Double getPriceById(@PathVariable ("id") int id) {
		return ps.getPriceById(id);
	}

}