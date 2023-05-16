package com.mindtreebank.bo;

import java.util.ArrayList;
import java.util.List;

import com.mindtreebank.dao.CustomerDao;
import com.mindtreebank.dao.CustomerDaoImplementation;
import com.mindtreebank.model.Customer;

public class CustomerBoImplementation implements CustomerBo{

	@Override
	public int addCustomer(Customer customer) {
		CustomerDao cdao=new CustomerDaoImplementation();
		int result=cdao.addCustomer(customer);
		return result;
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> list=new ArrayList<>();
		CustomerDao cdao=new CustomerDaoImplementation();
		list=cdao.getAllCustomers();
		return list;
	}

	@Override
	public Customer getCustomerById(String customerId) {
		CustomerDao cdao=new CustomerDaoImplementation();
		Customer customer=cdao.getCustomerById(customerId);
		return customer;
	}

	@Override
	public int DeleteCustomerById(String customerId) {
		CustomerDao cdao=new CustomerDaoImplementation();
		int status=cdao.DeleteCustomerById(customerId);
		return status;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		CustomerDao cdao=new CustomerDaoImplementation();
		Customer cust=cdao.updateCustomer(customer);
		return cust;
	}

	@Override
	public Customer updateCustomerById(String customerId) {
		CustomerDao cdao=new CustomerDaoImplementation();
		Customer cust=cdao.updateCustomerById(customerId);
		return cust;
	}

}
