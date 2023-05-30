package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Notice;

public interface AdminService {
	
	public void writeNotice(String username, Notice notice);
	
	public List<Notice> findAll();
	
	public Notice noticeDetail(Long id);
	
	public Long noticeCount(Long id);
	
	public void modify(Notice notice);
	
	public void delete(Long id);

}
