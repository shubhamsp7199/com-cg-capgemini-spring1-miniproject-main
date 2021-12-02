package com.capgemini.service;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.exceptions.NoSuchConsumerNumberException;
import com.capgemini.exceptions.NoSuchDateRangeException;
import com.capgemini.exceptions.NoSuchEmailException;
import com.capgemini.exceptions.NoSuchMobileNumberException;
import com.capgemini.model.Bill;

public interface BillService {
	public Object viewBillByConsumerNumber(Long consumerNumber) throws NoSuchConsumerNumberException;

	public Bill viewBillByMobileNumber(String mobileNumber) throws NoSuchMobileNumberException;

	public Bill viewBillByEmail(String email) throws NoSuchEmailException;

	public List<Bill> viewBillForDateRange(LocalDate from, LocalDate to) throws NoSuchDateRangeException;

}
