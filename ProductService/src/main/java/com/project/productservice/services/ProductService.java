//package com.project.productservice.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import com.project.productservice.models.Product;
//import com.project.productservice.models.ProductDetail;
//
//@Service
//public class ProductService {
//
//		@Autowired
//	 	private RestTemplate restTemplate;
//
//	    // URL of your "Product" microservice
//	    private static final String PRODUCT_URL = "http://USER-SERVICE/product";
//
//	    // URL of your "Product Details" microservice
//	    private static final String PRODUCT_DETAILS_SERVICE_URL = "http://PRODUCT-DETAILS-SERVICE/admin/productdetails";
//
//	    public Product getProductById(String productId) {
//	        ResponseEntity<Product> response = restTemplate.exchange(
//	            PRODUCT_URL + "/{id}",
//	            HttpMethod.GET,
//	            null,
//	            Product.class,
//	            productId
//	        );
//
//	        if (response.getStatusCode() == HttpStatus.OK) {
//	            return response.getBody();
//	        }
//
//	        return null; // Handle error or return a default product
//	    }
//
//	    public ProductDetail getProductDetailsById(String productId) {
//	        ResponseEntity<ProductDetail> response = restTemplate.exchange(
//	            PRODUCT_DETAILS_SERVICE_URL + "/{id}",
//	            HttpMethod.GET,
//	            null,
//	            ProductDetail.class,
//	            productId
//	        );
//
//	        if (response.getStatusCode() == HttpStatus.OK) {
//	            return response.getBody();
//	        }
//
//	        return null; // Handle error or return default details
//	    }
//	
//	
//	
//}
