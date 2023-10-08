package com.project.productservice.models;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDetail {

	private String id;
	private String qty;			//to show "out of stock"
	private double price;
	private String description;
	
	
}
