package com.project.usercart.models;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CartItemWithProduct {
	
	
	private Cart cart;
    private Product product;
    private String productName;  // Add product name field

    public CartItemWithProduct(Cart cart, Product product) {
        this.cart = cart;
        this.product = product;
        this.productName = product.getProductName(); // Set the product name
    }
	
	
	
//	private String id; // Cart item ID
//    private String userid;
//    private String productid;
//    private int quantity;
//    private Product productName; // Product name
//    private ProductDetails productDetails; // Product details
	
}
