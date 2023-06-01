package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Customer;
import com.example.demo.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public void signUp(Customer customer) {
		// TODO Auto-generated method stub
		String initPwd = customer.getPassword();
		String encodePwd = encoder.encode(initPwd);
		customer.setPassword(encodePwd);
		customer.setRole("ROLE_USER");
		memberRepository.save(customer);
	}

	@Transactional
	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		Customer updateCustomer = memberRepository.findById(customer.getNum()).get();
		String initPwd = customer.getPassword();
		String newPwd = encoder.encode(initPwd);
		updateCustomer.setPassword(newPwd);
		updateCustomer.setAddress(customer.getAddress());
		updateCustomer.setEmail(customer.getEmail());
		updateCustomer.setPhone(customer.getPhone());
	}

	@Override
	public void delete(Long num) {
		// TODO Auto-generated method stub
	    memberRepository.deleteById(num);	    
	}

}
