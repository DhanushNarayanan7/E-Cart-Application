package com.dhanush.prod.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhanush.prod.dao.productdao;
import com.dhanush.prod.dao.reviewdao;
import com.dhanush.prod.model.Product;
import com.dhanush.prod.model.Review;

@Service
public class ReviewService {

	@Autowired
	private reviewdao rd;
	
	@Autowired
	private productdao prd;
	
	public Review saveReview (Review rev) {
		return rd.save(rev);
	}
	
	
	public Review getReview(int id) {
		 Optional<Review> oprev = rd.findById(id);
	        if (oprev.isPresent()) {
	            return oprev.get();
	        }
	        return null;
	}
	
	public Review addreview(int id, Review rev) {
		// TODO Auto-generated method stub
		Optional<Product> pd = prd.findById(id);
		Product prod = pd.get();
		rev.setProduct(pd.get());
		 Review newrev = rd.save(rev);
		return newrev;
	}
}
