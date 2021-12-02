package com.capgemini.dao;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.model.Bill;

@Repository
public interface BillDao extends JpaRepository<Bill, Long> {

	@Query(value = "SELECT b FROM Bill b WHERE b.connection.consumerNumber = ?1")
	public Bill readBillByConsumerNumber(Long consumerNumber);

	@Query(value = "SELECT b FROM Bill b WHERE b.customer.mobileNumber = ?1")
	public Bill readBillByMobileNumber(String mobileNumber);

	@Query(value = "SELECT b FROM Bill b WHERE b.customer.email = ?1")
	public Bill readBillByEmail(String email);

	@Query(value = "SELECT b FROM Bill b WHERE b.billDate BETWEEN ?1 AND ?2")
	public List<Bill> readBillForDateRange(LocalDate from, LocalDate to);

}
