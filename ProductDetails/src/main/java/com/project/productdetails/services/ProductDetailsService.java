package com.project.productdetails.services;

import java.util.List;

import com.project.productdetails.beans.ProductDetails;

public interface ProductDetailsService {

	//create 
	public ProductDetails createProduct(ProductDetails product);
	
	//create list
	public List<ProductDetails> createListProducts(List<ProductDetails> products);
	
	//get all products
	public List<ProductDetails> getAllProducts();
	
	//get single product
	public ProductDetails getProduct(String id);
	
	//update product
	public ProductDetails updateProduct(String id, ProductDetails product);
	
	//delete product
	public void deleteProduct(String id);
	
	//findByProductId
	public ProductDetails findByProductId(String productId);
	
}
