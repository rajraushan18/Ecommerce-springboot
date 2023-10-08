package com.project.usercart.cartserviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.usercart.cartservice.CartService;
import com.project.usercart.cartservice.ProductServiceClient;
import com.project.usercart.exception.ResourceNotFoundException;
import com.project.usercart.models.Cart;
import com.project.usercart.models.CartItem;
import com.project.usercart.models.CartItemWithProduct;
import com.project.usercart.models.Product;
import com.project.usercart.models.ProductDetails;
import com.project.usercart.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository cartRepository;
//	@Autowired
//	private RestTemplate restTemplate;
	
//	@Autowired
//	private ProductServiceClient productServiceClient;
	
	//add cart
	@Override
	public Cart addCart(Cart cart) {
		String uuid = UUID.randomUUID().toString();
		cart.setId(uuid);
		Cart newCart = cartRepository.save(cart);
		return newCart;
	}
	
	@Override
	public List<Cart> getCart(String id){
		List<Cart> cart = cartRepository.findByUserid(id);
		return cart;
	}
	
	
//	public List<CartItemWithProduct> getCartItemsWithProductDetails(String userId) {
//        List<Cart> userCart = cartRepository.findByUserid(userId);
//        List<CartItemWithProduct> cartItemsWithProductDetails = new ArrayList<>();
//
//        for (Cart cartItem : userCart) {
//            // Use the Feign client to fetch product details for each item
//            Product product = productServiceClient.getProductById(cartItem.getProductid());
//            System.out.println("product-----"+product);
//            // Create a CartItem object combining cart information and product details
//            CartItemWithProduct cartItemWithDetails = new CartItemWithProduct(cartItem, product);
//            cartItemsWithProductDetails.add(cartItemWithDetails);
//        }
//
//        return cartItemsWithProductDetails;
//    }
	
	
	
	
	//get cart
//	@Override
//	public List<CartItemWithProduct> getCart(String uid) {
//		List<Cart> cart = cartRepository.findByUserid(uid);
//		List<CartItemWithProduct> cartItemsWithProduct = new ArrayList<>();
//		
//		 for (Cart item : cart) {
//		        // Fetch product information from the "Product" microservice
//		        ResponseEntity<Product> productResponse = restTemplate.exchange(
//		            "http://PRODUCT-SERVICE/admin/{id}",
//		            HttpMethod.GET,
//		            null,
//		            Product.class,
//		            item.getId() // Use the product ID from the cart item
//		        );
//
//		        // Fetch product details from the "Product Details" microservice
//		        ResponseEntity<ProductDetails> detailsResponse = restTemplate.exchange(
//		            "http://PRODUCT-SERVICE/admin/productdetails/productid/{id}",
//		            HttpMethod.GET,
//		            null,
//		            ProductDetails.class,
//		            item.getId() // Use the product ID from the cart item
//		        );
//
//		        // Check if both requests were successful
//		        if (productResponse.getStatusCode() == HttpStatus.OK && detailsResponse.getStatusCode() == HttpStatus.OK) {
//		            // Update the cart item with product name and details
//		            Product product = productResponse.getBody();
//		            ProductDetails details = detailsResponse.getBody();
//		            CartItemWithProduct cartItemWithProduct = new CartItemWithProduct(
//		                    item.getId(),
//		                    item.getUserid(),
//		                    item.getProductid(),
//		                    item.getQuantity(),
//		                    product.getProductName(),
//		                    details
//		                );
//		            cartItemsWithProduct.add(cartItemWithProduct);
//		        }
//		    }
//
//		
//		return cartItemsWithProduct;
//	}
	
	//delete cart
	@Override
	public Cart deleteCart(String pid) {
		// TODO Auto-generated method stub
		return null;
	}


//	@Override
//	public List<Cart> getCart(String uid) {
//		// TODO Auto-generated method stub
//		return null;
//	}



	
}
