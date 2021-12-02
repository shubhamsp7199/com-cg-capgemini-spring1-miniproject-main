package com.cg.spring.boot.demo.service;

import java.util.List;

import com.cg.spring.boot.demo.exception.DuplicateCustomerException;
import com.cg.spring.boot.demo.exception.NoSuchCustomerException;
import com.cg.spring.boot.demo.model.Connection;
import com.cg.spring.boot.demo.model.Customer;

public interface CustomerService {
	// check for Duplicate addhar, email, mobile
	public Customer registerCustomer(Customer customer)throws DuplicateCustomerException;
	public Customer viewCustomerProfile(Long customerId)throws NoSuchCustomerException;
	public Customer editCustomerProfile(Integer customerId)throws NoSuchCustomerException;//see it
	public Customer searchCustomerByCustomerId(Long customerId)throws NoSuchCustomerException;
	public List<Customer> searchCustomerByEmail(String email)throws NoSuchCustomerException;
	public Customer searchCustomerByAaddhar(Long aadharNumber)throws NoSuchCustomerException;
	public Customer searchCustomerByMobile(String mobile)throws NoSuchCustomerException;
	public List<Customer> searchCustomerByName(String customerName)throws NoSuchCustomerException;
	
}

