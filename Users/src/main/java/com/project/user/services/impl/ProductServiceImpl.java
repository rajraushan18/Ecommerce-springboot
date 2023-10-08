package com.project.user.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.user.beans.Product;
import com.project.user.exceptions.ResourceNotFoundException;
import com.project.user.repo.ProductRepository;
import com.project.user.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;

	//create
	@Override
	public Product createProduct(Product product) {
		String randomUID = UUID.randomUUID().toString();
		product.setPid(randomUID);
		Product newProduct = productRepository.save(product);
		return newProduct;
	}

	//list of products
	@Override
	public List<Product> createListProducts(List<Product> products) {
		for(Product product : products) {
			String randomUID = UUID.randomUUID().toString();
			product.setPid(randomUID);
			productRepository.save(product);
		}
		return products;
	}

	//get all products
	@Override
	public List<Product> getAllProducts() {
		List<Product> products = productRepository.findAll();
		return products;
	}

	//get single project
	@Override
	public Product getProduct(String id) {
		Product product = productRepository.findById(id)
								.orElseThrow(() -> new ResourceNotFoundException("No product with given id found!!"));
		return product;
	}

	//update product
	@Override
	public Product updateProduct(String id, Product product) {
		Optional<Product> existedProduct = productRepository.findById(id);
		if(existedProduct.isPresent()) {
			Product updateProduct = existedProduct.get();
			
			updateProduct.setProductName(product.getProductName());
			updateProduct.setCategory(product.getCategory());
			
			return productRepository.save(updateProduct);
		}else {
			throw new ResourceNotFoundException("No product with given id found!!");
		}
		
	}

	//delete product
	@Override
	public void deleteProduct(String id) {
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
			productRepository.deleteById(id);
		}else {
			throw new ResourceNotFoundException("No product with given id found!!");
		}
		
	}
	
	
	
	
	
}
