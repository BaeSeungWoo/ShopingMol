package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	public Notice noticeDetail(Long id) {
		return noticeRepository.findById(id).get();
	}

	@Transactional
	@Override
	public Long noticeCount(Long id) {
		noticeRepository.upCount(noticeRepository.findById(id).get().getCount(), id);
		return noticeRepository.findById(id).get().getCount();
	}

	@Transactional
	@Override
	public void modify(Notice notice) {
		Date modifyDate = new Date(System.currentTimeMillis());
		Notice newNotice = noticeRepository.findById(notice.getId()).get();
		newNotice.setContents(notice.getContents());
		newNotice.setSubject(notice.getSubject());
		newNotice.setRegDate(modifyDate);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		noticeRepository.deleteById(id);;		
	}

}
