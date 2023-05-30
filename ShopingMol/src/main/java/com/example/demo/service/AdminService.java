package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Notice;

public interface AdminService {
	
	public void writeNotice(String username, Notice notice);
	
	public List<Notice> findAll();

}
