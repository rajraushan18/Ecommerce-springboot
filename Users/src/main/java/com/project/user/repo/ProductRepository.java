package com.project.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.user.beans.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

}
