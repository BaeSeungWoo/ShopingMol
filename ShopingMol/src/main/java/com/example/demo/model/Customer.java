package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;
	private String email;
	private String password;
	@Embedded
	private Address address;
	private String birth;
	private Long age;
	private String phone;
	private String gender;
	private String name;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Order> order;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Comment> comment;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Cart> cart;
}
