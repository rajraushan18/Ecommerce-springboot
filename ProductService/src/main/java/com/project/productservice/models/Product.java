package com.project.productservice.models;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class Product {

	private String pid;
	private String productName;
	private String category;
	
	private ProductDetail productDetail;
	
}
