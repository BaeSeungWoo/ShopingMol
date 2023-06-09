package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
	
	@GetMapping("noticeDetail/{id}")
	public String noticeDetail(@PathVariable Long id, Model model) {
		model.addAttribute("notice", adminService.noticeDetail(id));
		model.addAttribute("noticeCount", adminService.noticeCount(id));
		return "admin/noticeDetail";
	}
	
}
