package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.model.Notice;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.NoticeRepository;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private NoticeRepository noticeRepository;

	@Override
	public void writeNotice(String username, Notice notice) {
		Customer writer = adminRepository.findByUsername(username);
		notice.setCustomer(writer);
		noticeRepository.save(notice);
	}

	@Override
	public List<Notice> findAll() {
		// TODO Auto-generated method stub
		return noticeRepository.findAll();
	}

}
