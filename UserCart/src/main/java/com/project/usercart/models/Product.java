package com.project.usercart.models;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Product {

	private String id;
	private String productName;
	
	private ProductDetails productDetails;
	
}
