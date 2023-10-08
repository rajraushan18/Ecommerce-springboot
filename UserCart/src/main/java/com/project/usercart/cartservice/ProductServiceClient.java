package com.project.usercart.cartservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.usercart.models.Product;

@FeignClient(name="PRODUCT-SERVICE")
public interface ProductServiceClient {

	@GetMapping("/admin/{id}")
    Product getProductById(@PathVariable("id") String id);
	
}
