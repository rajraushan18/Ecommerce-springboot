package com.project.user.services;

import java.util.List;

import com.project.user.beans.Product;

public interface ProductService {

	//create products
	Product createProduct(Product product);
	
	//create multiple products
	List<Product> createListProducts(List<Product> product);
	
	//get all products
	List<Product> getAllProducts();
	
	//get single product
	Product getProduct(String id);
	
	//update product
	Product updateProduct(String id, Product product);
	
	//delete product
	void deleteProduct(String id);
	
	
}
