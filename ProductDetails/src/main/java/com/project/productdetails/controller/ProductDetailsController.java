package com.project.productdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.productdetails.beans.ProductDetails;
import com.project.productdetails.services.ProductDetailsService;

@RestController
@RequestMapping("/admin/productdetails")
public class ProductDetailsController {

	@Autowired
	private ProductDetailsService productDetailsService;
	
	//create
	@PostMapping
	public ResponseEntity<ProductDetails> create(@RequestBody ProductDetails product){
		ProductDetails createProduct = productDetailsService.createProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(createProduct);
	}
	
	//create list products				//------this is adding same products twice, add checking method
	@PostMapping("/add-details")
	public ResponseEntity<List<ProductDetails>> createProduct(@RequestBody List<ProductDetails> products){
		List<ProductDetails> listProducts = productDetailsService.createListProducts(products);
		return ResponseEntity.status(HttpStatus.CREATED).body(listProducts);
	}
	
	//get product details by product id
	@GetMapping("/productid/{pid}")
	public ResponseEntity<ProductDetails> getProductByProductId(@PathVariable String pid){
		ProductDetails findByProductId = productDetailsService.findByProductId(pid);
		return ResponseEntity.ok(findByProductId);
	}
	
	
	//get all products
	@GetMapping
	public ResponseEntity<List<ProductDetails>> getAllProducts(){
		List<ProductDetails> allProducts = productDetailsService.getAllProducts();
		return ResponseEntity.ok(allProducts);
	}
	
	//get single product
	@GetMapping("/{id}")
	public ResponseEntity<ProductDetails> getProduct(@PathVariable String id){
		ProductDetails product = productDetailsService.getProduct(id);
		return ResponseEntity.ok(product);
	}
	
	//update product
	@PutMapping("/{id}")
	public ResponseEntity<ProductDetails> updateProduct(@PathVariable String id, @RequestBody ProductDetails product){
		ProductDetails updateProduct = productDetailsService.updateProduct(id, product);
		return ResponseEntity.status(HttpStatus.CREATED).body(updateProduct);
	}
	
	//delete product
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable String id){
		productDetailsService.deleteProduct(id);
		return ResponseEntity.ok("product deleted!!!");
	}
	
	
	
}
