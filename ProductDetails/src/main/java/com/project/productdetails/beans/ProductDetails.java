package com.project.productdetails.beans;

import org.hibernate.annotations.ForeignKey;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class ProductDetails {

	@Id
	private String id;
	private String qty;			//to show "out of stock"
	private double price;
	private String description;
	
	private String productId;	
	
	
}
