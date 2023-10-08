package com.project.productdetails.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.productdetails.beans.ProductDetails;
import com.project.productdetails.exceptions.ResourceNotFoundException;
import com.project.productdetails.repo.ProductDetailsRepo;
import com.project.productdetails.services.ProductDetailsService;

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {

	@Autowired
	private ProductDetailsRepo productDetailsRepo;
	
	@Override
	public ProductDetails createProduct(ProductDetails product) {
		String uid = UUID.randomUUID().toString();
		product.setId(uid);
		ProductDetails newProduct = productDetailsRepo.save(product);
		return newProduct;
	}

	@Override
	public List<ProductDetails> createListProducts(List<ProductDetails> products) {
		
		for(ProductDetails product : products) {
			String uid = UUID.randomUUID().toString();
			product.setId(uid);
			productDetailsRepo.save(product);
		}
		return products;
	}

	@Override
	public List<ProductDetails> getAllProducts() {
		List<ProductDetails> products = productDetailsRepo.findAll();
		return products;
	}

	@Override
	public ProductDetails getProduct(String id) {
		ProductDetails product = productDetailsRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No product found with the given id"));
		return product;
	}


	@Override
	public ProductDetails updateProduct(String id, ProductDetails product) {
		Optional<ProductDetails> optionalProduct = productDetailsRepo.findById(id);
		if(optionalProduct.isPresent()) {
			ProductDetails existedProduct = optionalProduct.get();
			
			existedProduct.setDescription(product.getDescription());
			existedProduct.setPrice(product.getPrice());
			existedProduct.setQty(product.getQty());
			existedProduct.setProductId(product.getProductId());
			
			return productDetailsRepo.save(existedProduct);
		}else {
			throw new ResourceNotFoundException("No product with given id found!!");
			
		}
	}

	@Override
	public void deleteProduct(String id) {
		if(productDetailsRepo.findById(id) != null) {
			productDetailsRepo.deleteById(id);
		}else {
			throw new ResourceNotFoundException("No product with given id found!!");
		}
		
	}

	@Override
	public ProductDetails findByProductId(String productId) {
		// TODO Auto-generated method stub
		return productDetailsRepo.findByProductId(productId);
	}

	

	
	
	
}
