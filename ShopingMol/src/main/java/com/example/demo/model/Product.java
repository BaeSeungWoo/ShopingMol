package com.example.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "productsList")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;
	private String name;
	private Long price;
	private Long counts;
	private String picture;
	private Long views;
	private String contents;
	private Date deliverDate;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Comment> comment;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Cart> cart;

}
