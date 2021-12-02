package com.capgemini.service;

import java.util.List;

import com.capgemini.exceptions.NoSuchCustomerException;
import com.capgemini.model.Payment;
import com.capgemini.model.PaymentStatus;

public interface PaymentService {
	public PaymentStatus payBill(Payment payment);
	public void sendEmailOnPaymentCompletion(Long consumerId, String email);
	public List<Payment> viewHistoricalPayment(Long consumerNumber)throws NoSuchCustomerException;
	
}
