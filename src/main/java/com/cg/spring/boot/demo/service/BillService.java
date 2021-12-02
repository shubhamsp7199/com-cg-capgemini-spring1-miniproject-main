package com.cg.spring.boot.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.spring.boot.demo.exception.NoSuchConsumerNumberException;
import com.cg.spring.boot.demo.exception.NoSuchDateRangeException;
import com.cg.spring.boot.demo.exception.NoSuchEmailException;
import com.cg.spring.boot.demo.exception.NoSuchMobileNumberException;
import com.cg.spring.boot.demo.model.Bill;



public interface BillService {
	public Object viewBillByConsumerNumber(Long consumerNumber) throws NoSuchConsumerNumberException;

	public Bill viewBillByMobileNumber(String mobileNumber) throws NoSuchMobileNumberException;

	public Bill viewBillByEmail(String email) throws NoSuchEmailException;

	public List<Bill> viewBillForDateRange(LocalDate from, LocalDate to) throws NoSuchDateRangeException;

}
