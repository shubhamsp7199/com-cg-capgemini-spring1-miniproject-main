package com.cg.spring.boot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import  com.cg.spring.boot.demo.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


//	public Customer findByAadhar(Long aadharNumber);


}