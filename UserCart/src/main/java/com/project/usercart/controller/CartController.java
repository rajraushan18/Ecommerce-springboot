package com.project.usercart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.usercart.cartservice.CartService;
import com.project.usercart.models.Cart;
import com.project.usercart.models.CartItem;
import com.project.usercart.models.CartItemWithProduct;


@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	//add cart
	@PostMapping
	public ResponseEntity<Cart> addCart(@RequestBody Cart cart) {
		Cart addCart = cartService.addCart(cart);
		return ResponseEntity.status(HttpStatus.CREATED).body(addCart);
	}
	
	//get cart
	@GetMapping("/{uid}")
	public ResponseEntity<List<Cart>> getCart(@PathVariable String uid){
		List<Cart> userCart = cartService.getCart(uid);
		System.out.println(userCart);
		return ResponseEntity.ok(userCart);
	}
	
	
}
