package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Notice;
import com.example.demo.service.AdminService;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("writeNotice")
	public String writeNotice() {
		return "admin/writeNotice";
	}

	@PostMapping("writeNotice/{username}")
	@ResponseBody
	public String writeNotice(@PathVariable String username, @RequestBody Notice notice) {
		adminService.writeNotice(username, notice);
		return "success";
	}
}
