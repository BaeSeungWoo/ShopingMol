package com.example.demo.service;

import com.example.demo.model.Customer;

public interface MemberService {
	
	public void signUp(Customer customer);
	
	public void update(Customer customer);
	
	public void delete(Long num);
	
}
