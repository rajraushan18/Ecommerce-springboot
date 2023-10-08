package com.project.productdetails.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.productdetails.beans.ProductDetails;

public interface ProductDetailsRepo extends JpaRepository<ProductDetails, String> {

	ProductDetails findByProductId(String productId);
	
}
