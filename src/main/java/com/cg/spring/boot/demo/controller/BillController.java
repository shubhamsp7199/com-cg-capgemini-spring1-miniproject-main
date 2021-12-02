package com.cg.spring.boot.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.boot.demo.exception.NoSuchConsumerNumberException;
import com.cg.spring.boot.demo.exception.NoSuchDateRangeException;
import com.cg.spring.boot.demo.exception.NoSuchEmailException;
import com.cg.spring.boot.demo.exception.NoSuchMobileNumberException;
import com.cg.spring.boot.demo.model.Bill;
import com.cg.spring.boot.demo.service.BillServiceImpl;



@RestController
public class BillController {
	
	private static final Logger LOG = LoggerFactory.getLogger(BillController.class);
	
	@Autowired
	private BillServiceImpl billServiceImpl;
	
	// http://localhost:8082/viewBillByConsumerNumber/
	@GetMapping("/viewBillByConsumerNumber/{consumerNumber}")
	public ResponseEntity<Bill> viewBillByConsumerNumber(@PathVariable(name = "consumerNumber")Long consumerNumberLong) 
			throws NoSuchConsumerNumberException {
		LOG.info("viewBillByConsumerNumber");
		Bill bill = billServiceImpl.viewBillByConsumerNumber(consumerNumberLong);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This bill is available in the database ");
		LOG.info(headers.toString());
		ResponseEntity<Bill> response = new ResponseEntity<Bill>(bill, headers, HttpStatus.OK);
		return response;
	}
	
	
	// http://localhost:8082/viewBillByMobileNumber/
	@GetMapping("/viewBillByMobileNumber/{mobileNumber}")
	public ResponseEntity<Bill> viewBillByMobileNumber(@PathVariable(name = "mobileNumber")String mobileNumber) throws NoSuchMobileNumberException {
		LOG.info("viewBillByMobileNumber");
		Bill bill = billServiceImpl.viewBillByMobileNumber(mobileNumber);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This bill is available in the database ");
		LOG.info(headers.toString());
		ResponseEntity<Bill> response = new ResponseEntity<Bill>(bill, headers, HttpStatus.OK);
		return response;
	}
	
	// http://localhost:8082/viewBillByEmail/
	@GetMapping("/viewBillByEmail/{email}")
	public ResponseEntity<Bill> viewBillByEmail(@PathVariable(name = "email")String email) throws NoSuchEmailException {
		LOG.info("viewBillByEmail");
		Bill bill = billServiceImpl.viewBillByEmail(email);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This bill is available in the database ");
		LOG.info(headers.toString());
		ResponseEntity<Bill> response = new ResponseEntity<Bill>(bill, headers, HttpStatus.OK);
		return response;
	}
	
	
	// http://localhost:8082/getbydatebet/2021-10-01/2021-11-01
	@GetMapping("/getbydatebet/{from}/{to}")
	public List<Bill> readBillForDateRange(@PathVariable(name = "from")String from, @PathVariable(name = "to")String to) 
			throws NoSuchDateRangeException {
		LOG.info("readBillForDateRange");
		LOG.info("from==>{}",from);
		LOG.info("to==>{}",to);
		LocalDate fromDate = LocalDate.parse(from);
		LocalDate toDate = LocalDate.parse(to);

		LOG.info("fromDate==>{}",fromDate);
		LOG.info("toDate==>{}",toDate);
		return billServiceImpl.viewBillForDateRange(fromDate, toDate);

	}

}
