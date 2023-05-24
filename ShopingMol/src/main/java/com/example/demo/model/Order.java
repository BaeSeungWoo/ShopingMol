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
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;
	@ManyToOne
	@JoinColumn(name = "userNum")
	private Customer customer;
	private Date orderdate;
	private String receiver;
	private String receiverPhone;
	private String receiverAddress;
	private String receiverZipcode;
	private Long allPrice;
	private Long pay;

}
