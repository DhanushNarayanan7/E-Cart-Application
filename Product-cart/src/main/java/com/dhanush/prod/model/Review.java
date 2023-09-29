package com.dhanush.prod.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private int reviewId;
	private int stars;
	private String author;
	private String body;

	@ManyToOne (cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "id")
	//@JsonManagedReference
	private Product product;
	
	

	public Review() {
		
	}

	public Review(int stars, String author, String body, Product product) {
		super();
		this.stars = stars;
		this.author = author;
		this.body = body;
		this.product = product;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
