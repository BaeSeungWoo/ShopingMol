package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Customer;

public interface AdminRepository extends JpaRepository<Customer, Long>{

	public Customer findByUsername(String username);
}
