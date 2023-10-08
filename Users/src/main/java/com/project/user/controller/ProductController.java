package com.project.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.user.beans.Product;
import com.project.user.services.ProductService;



@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	//create
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<Product> create(@RequestBody Product product){
		Product createProduct = productService.createProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(createProduct);
	}
	
	//create list products
	@PostMapping("/list-products")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<List<Product>> createProduct(@RequestBody List<Product> products){
		List<Product> listProducts = productService.createListProducts(products);
		return ResponseEntity.status(HttpStatus.CREATED).body(listProducts);
	}
	
	//get all products
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ROLE_NORMAL')")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> allProducts = productService.getAllProducts();
		return ResponseEntity.ok(allProducts);
	}
	
	//get single product
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ROLE_NORMAL')")
	public ResponseEntity<Product> getProduct(@PathVariable String id){
		Product product = productService.getProduct(id);
		return ResponseEntity.ok(product);
	}
	
	//update product
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product product){
		Product updateProduct = productService.updateProduct(id, product);
		return ResponseEntity.status(HttpStatus.CREATED).body(updateProduct);
	}
	
	//delete product
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<String> deleteProduct(@PathVariable String id){
		productService.deleteProduct(id);
		return ResponseEntity.ok("product deleted!!!");
	}
	
	
}
