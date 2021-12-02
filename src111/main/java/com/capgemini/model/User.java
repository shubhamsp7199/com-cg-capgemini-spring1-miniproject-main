package com.capgemini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_table")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	// need to unique and should not allow null value. store email in userName
	@Column
	private String userName;
	
	// you as developer define password complexity
	@Column
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	public User() {
		super();
	}

	public User(Long userId, String userName, String password, Customer customer) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.customer = customer;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", customer=" + customer
				+ "]";
	}
	
	
	
}
