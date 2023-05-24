package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	@GetMapping("adminLogin")
	public String adminLogin() {
		return "admin/adminLogin";
	}

}