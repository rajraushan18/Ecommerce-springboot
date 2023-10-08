package com.project.productservice.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.productservice.models.Product;
import com.project.productservice.models.ProductDetail;
import com.project.productservice.models.ProductWithDetails;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/service")
public class ProductController {

	private Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{id}")
    //fallback will be used when there is a fault
    //@CircuitBreaker(name = "productDetailsBreaker", fallbackMethod = "productDetailFallback")
    //rate limiter ---- it will limit the call request user per second
    //@RateLimiter(name="productRateLimiter", fallbackMethod = "productDetailFallback")
    public ResponseEntity<?> getProductWithDetails(@PathVariable String id) {
        // Step 1: Fetch basic product information from the "Product" microservice
        ResponseEntity<Product> productResponse = restTemplate.exchange(
            "http://USER-SERVICE/product/{id}",
            HttpMethod.GET,
            null,
            Product.class,
            id
        );
        // Step 2: Fetch product details from the "Product Details" microservice
        ResponseEntity<ProductDetail> detailsResponse = restTemplate.exchange(
            "http://PRODUCT-DETAILS-SERVICE/admin/productdetails/productid/{id}",
            HttpMethod.GET,
            null,
            ProductDetail.class,
            id
        );
        System.out.println(detailsResponse);
        // Check if both requests were successful
        if (productResponse.getStatusCode() == HttpStatus.OK && detailsResponse.getStatusCode() == HttpStatus.OK) {
            // Step 3: Combine product and product details
            Product product = productResponse.getBody();
            ProductDetail details = detailsResponse.getBody();
            
            // Create a combined response object
            ProductWithDetails response = new ProductWithDetails(product, details);
            
            // Step 4: Return the combined response to the client
            return ResponseEntity.ok(response);
        } else {
            // Handle errors appropriately
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch product information.");
        }
    }
	
	//fall back method
    public ResponseEntity<?> productDetailFallback(String id, Exception ex){
    	logger.info("fallback executed beacause service is down", ex.getMessage());
    	// You can return a custom fallback response or any appropriate message.
        String fallbackMessage = "Service is temporarily unavailable. Please try again later.";
        
        // You can also log the exception or take any other actions as needed.

        // Return a ResponseEntity with an appropriate HTTP status code and the fallback message.
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(fallbackMessage);
    	
    }
	
	
	
	
//	    @Autowired
//	    private ProductService productService;
//
//	    @GetMapping("/product/{id}")
//	    public ResponseEntity<Product> getProduct(@PathVariable String id) {
//	    	System.out.println("inside get request");
//	        Product product = productService.getProductById(id);
//	        if (product != null) {
//	            return ResponseEntity.ok(product);
//	        } else {
//	            return ResponseEntity.notFound().build();
//	        }
//	    }
//
//	    @GetMapping("/product-details/{id}")
//	    public ResponseEntity<ProductDetail> getProductDetails(@PathVariable String id) {
//	        ProductDetail details = productService.getProductDetailsById(id);
//	        if (details != null) {
//	            return ResponseEntity.ok(details);
//	        } else {
//	            return ResponseEntity.notFound().build();
//	        }
//	    }
	
}
