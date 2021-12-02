package com.cg.spring.boot.demo.service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Optional;

import com.cg.spring.boot.demo.exception.DuplicateCustomerException;
import com.cg.spring.boot.demo.exception.NoSuchCustomerException;
import com.cg.spring.boot.demo.model.Customer;

import com.cg.spring.boot.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImplemetation  implements CustomerService{
	
	private static final Logger LOG = LoggerFactory.getLogger(CustomerServiceImplemetation.class);
	
	@Autowired
	CustomerRepository customerRepository ;
	@Override
	public Customer registerCustomer(Customer customer) throws DuplicateCustomerException {
		// TODO Auto-generated method stub
		LOG.info("register");
		if ( customerRepository.existsById(customer.getCustomerId()))
			throw new DuplicateCustomerException("customer already exists");
		return customerRepository.save(customer);
	}

	@Override
	public Customer viewCustomerProfile(Long CustomerId) throws NoSuchCustomerException {
		LOG.info("getCustomerById");
		Optional<Customer> empOpt = customerRepository.findById(CustomerId);
		if (empOpt.isPresent()) {
			LOG.info("Customer is available.");
			return empOpt.get();
		} else {
			LOG.info("customer is NOT available.");
			throw new NoSuchCustomerException(CustomerId + " this customer is not found.");
		}
	}

	@Override
	public Customer editCustomerProfile(Integer customerId) throws NoSuchCustomerException {
		// TODO Auto-generated method stub
		/*
		 * System.out.println("Service updatecustomer "); Optional<Customer> empo =
		 * CustomerRepository.findById(customerId); if
		 * (CustomerRepository.existsById(customer.getCustomerId()))
		 * 
		 * return CustomerRepository.save(customer);
		 * 
		 * System.out.println(customer.getCustomerId() + " customer does not exist.");
		 * return null;
		 */
		
		
		/*
		 * public Optional<Customer> editCustomerProfile(Integer customerId ) {
		 * System.out.println("update service"); return
		 * CustomerRepository.findById(customerId).map(customer -> { // add more logic
		 * customer.setCustomerId(customer. getCustomerId()); // write all fields
		 * updates return CustomerRepository.save(customer); }); }
		 */
		return null;
	}

@Override
public Customer searchCustomerByCustomerId(Long customerId) throws NoSuchCustomerException {
	// TODO Auto-generated method stub
	
	return null;
}

@Override
public List<Customer> searchCustomerByEmail(String email) throws NoSuchCustomerException {
	// TODO Auto-generated method stub
	LOG.info("get customer by email");
	return  ((CustomerService) customerRepository).searchCustomerByEmail(email);
	//return null;
}



@Override
public Customer searchCustomerByMobile(String mobile) throws NoSuchCustomerException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Customer> searchCustomerByName(String customerName) throws NoSuchCustomerException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Customer searchCustomerByAaddhar(Long aadharNumber) throws NoSuchCustomerException {
	// TODO Auto-generated method stub

//		System.out.println("getCustomerByAddhar");
//		Optional<Customer> empOpt = Optional.of(customerRepository.findByAadhar(aadharNumber));
//		if (empOpt.isPresent()) {
//			System.out.println("Customer is available.");
//			return empOpt.get();
//		} else {
//			System.out.println("customer is NOT available.");
//			throw new NoSuchCustomerException(aadharNumber + " this customer is not found.");
//		}
//		
//	}
//	
	return null;
  }
}


