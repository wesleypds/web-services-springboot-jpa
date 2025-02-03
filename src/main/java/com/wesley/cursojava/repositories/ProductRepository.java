package com.wesley.cursojava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wesley.cursojava.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    
}