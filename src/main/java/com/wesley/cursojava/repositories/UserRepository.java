package com.wesley.cursojava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wesley.cursojava.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
