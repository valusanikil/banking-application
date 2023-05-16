package com.mindtreebank.dao;

import java.util.List;

import com.mindtreebank.model.Customer;

public interface CustomerDao {
	
	 public int addCustomer(Customer customer);
	 public List<Customer> getAllCustomers();
	 public Customer getCustomerById(String customerId);
	 public int DeleteCustomerById(String customerId);
	 public Customer updateCustomer(Customer customer);
	 public Customer updateCustomerById(String customerId);
}
