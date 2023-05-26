package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Customer;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberservice;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	@GetMapping("SignUp")
	public String signUp() {
		return "member/signUp";
	}
	
	@PostMapping("SignUp")
	@ResponseBody
	public String signUp(@RequestBody Customer customer) {
		if(memberRepository.findByUsername(customer.getUsername()) != null) {
			return "fail";
		} else {
			memberservice.signUp(customer);
			return "success";
		}		
	}
}
