package com.dhanush.product.model;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonAlias;

@Service
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private LocalDateTime date;
	private double amount;
	private String user;

	public Order() {
		super();
	}

	public Order(int id, LocalDateTime date, double amount, String user) {
		super();
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	 public static Order jsonStringToJavaObject(String json) throws IOException {
		  
	        Order confirmation = new Order();

	        // InputStream is = new ByteArrayInputStream(json.getBytes());
	        // InputStream is = new ByteArrayInputStream(json.getBytes());
	        // JsonReader jsonReader = Json.createReader(is);
	        StringReader sr = new StringReader(json);
	        JsonReader jsonReader = Json.createReader(sr);
	        JsonObject jsonObject = jsonReader.readObject();
	        
	        confirmation.setId(jsonObject.getInt("id"));
	        String date = jsonObject.getString("date");
	        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss");
	        LocalDateTime dateTime = LocalDateTime.parse(date, dtf);
	        confirmation.setDate(dateTime);
	        confirmation.setAmount(jsonObject.getInt("amount"));
	        confirmation.setUser(jsonObject.getString("user"));

	    
	        return confirmation;
	    }

}
