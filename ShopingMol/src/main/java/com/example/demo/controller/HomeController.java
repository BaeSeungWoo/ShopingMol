package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.AdminService;

@Controller
public class HomeController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/")
	public String main() {
		return "home";
	}
	
	@GetMapping("notice")
	public String notice(Model model) {
		model.addAttribute("notice", adminService.findAll());
		return "admin/notice";
	}

}
