package com.project.usercart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.usercart.models.Cart;

public interface CartRepository extends JpaRepository<Cart, String> {

	List<Cart> findByUserid(String uid);
	
}
