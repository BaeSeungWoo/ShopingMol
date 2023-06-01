package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Customer;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
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
	
	@GetMapping("update")
	public String update() {
		return "member/update";
	}
	
	@PostMapping("SignUp")
	@ResponseBody
	public String signUp(@RequestBody Customer customer) {
		if(memberRepository.findByUsername(customer.getUsername()) != null) {
			return "fail";
		} else {
			memberService.signUp(customer);
			return "success";
		}		
	}
	
	@PutMapping("update")
	@ResponseBody
	public String update(@RequestBody Customer customer) {
		memberService.update(customer);
		return "success";
	}
	
	@DeleteMapping("delete/{num}")
	@ResponseBody
	public String delete(@PathVariable Long num) {
		memberService.delete(num);
		return "success";
	}
}
