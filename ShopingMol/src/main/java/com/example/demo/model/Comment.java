package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "commentList")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;
	@ManyToOne
	@JoinColumn(name = "productNum")
	private Product product;
	@ManyToOne
	@JoinColumn(name = "user")
	private Customer customer;
	private Date regDate;
	private Date modifyDate;
	private String picture;
	private String contents;

}
