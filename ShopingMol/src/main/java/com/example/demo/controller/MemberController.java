package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberservice;
	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	@GetMapping("SignUp")
	public String signUp() {
		return "member/signUp";
	}

}
