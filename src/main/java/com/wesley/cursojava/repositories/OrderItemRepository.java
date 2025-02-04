package com.wesley.cursojava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wesley.cursojava.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    
}
