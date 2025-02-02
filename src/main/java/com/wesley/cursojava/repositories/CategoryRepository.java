package com.wesley.cursojava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wesley.cursojava.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
