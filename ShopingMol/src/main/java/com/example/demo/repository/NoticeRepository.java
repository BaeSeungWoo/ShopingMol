package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long>{
	
	@Modifying
	@Query(value = "UPDATE notice_list SET count = ?1+1 WHERE id = ?2", nativeQuery = true)
	public void upCount(Long count, Long id);

}
