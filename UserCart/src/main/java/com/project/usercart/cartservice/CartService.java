package com.project.usercart.cartservice;

import java.util.List;

import com.project.usercart.models.Cart;
import com.project.usercart.models.CartItem;
import com.project.usercart.models.CartItemWithProduct;

public interface CartService {

	//add to cart
	public Cart addCart(Cart cart);
	
//	public List<CartItemWithProduct> getCartItemsWithProductDetails(String uid);
	
	public List<Cart> getCart(String uid);
	
	//get cart
//	public List<CartItemWithProduct> getCart(String uid);
	
	//delete cart
	public Cart deleteCart(String pid);
	
}
