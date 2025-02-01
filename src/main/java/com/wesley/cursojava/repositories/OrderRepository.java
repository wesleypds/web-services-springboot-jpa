package com.wesley.cursojava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wesley.cursojava.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
