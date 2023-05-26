package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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

}
