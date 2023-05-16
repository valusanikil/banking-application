package com.mindtreebank.io;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mindtreebank.bo.CustomerBo;
import com.mindtreebank.bo.CustomerBoImplementation;
import com.mindtreebank.model.Customer;

public class BankMain {
	public static void main(String[] args) throws ParseException {
		
//		registerCustomer();
//		getCustomerById();
		getAllCustomers();	
//		deleteCustomerById();
//		updateCustomer();
//		updateCustomerById();
		
	}

	private static void updateCustomerById() {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the customer id you want to update");
		String id=s.nextLine();
		CustomerBo cbo=new CustomerBoImplementation();
		Customer cust=cbo.updateCustomerById(id);
		if(cust!=null) {
			System.out.println(cust);
		}
		else {
			System.out.println("No customer found with the data");
		}
	}

	private static void updateCustomer() throws ParseException {
		Scanner s=new Scanner(System.in);
		Customer c=new Customer();
		System.out.println("Enter the customer number you want to update");
		c.setCustomerNumber(s.nextLine());
		System.out.println("Enter the customer new first name");
		c.setFirstName(s.nextLine());
		System.out.println("Enter the customer new middle name");
		c.setMiddleName(s.nextLine());
		System.out.println("Enter the customer new last name");
		c.setLastname(s.nextLine());
		System.out.println("Enter the customer new city name");
		c.setCity(s.nextLine());
		System.out.println("Enter the customer new contact number");
		c.setContactNo(s.nextLine());
		System.out.println("Enter the customer new occupation");
		c.setOccupation(s.nextLine());
		System.out.println("Enter the customer new date of birth(YYYY-MM-DD)");
		String dob=s.nextLine();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		c.setDob(sdf.parse(dob));
		CustomerBo cbo=new CustomerBoImplementation();
		Customer cust=cbo.updateCustomer(c);
		if(cust!=null) {
			System.out.println(cust);
		}
		else {
			System.out.println("No customer found with the given data");
		}
	}

	private static void deleteCustomerById() {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the id you want to delete");
		String mid=s.nextLine();
		CustomerBo cbo=new CustomerBoImplementation();
		int status=cbo.DeleteCustomerById(mid);
		if(status!=0) {
			System.out.println("Data is deleted");
		}
		else {
			System.out.println("No data found with the given id");
		}
	}

	private static void getAllCustomers() {
		List<Customer> list=new ArrayList<Customer>();
		CustomerBo cbo=new CustomerBoImplementation();
		list=cbo.getAllCustomers();
		if(list.isEmpty()) {
			System.out.println("No data found");
		}
		else {
			for(Customer l:list) {
				System.out.println(l);
				System.out.println();
			}
		}
	}

	private static void getCustomerById() {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the customer id you want to get");
		String customerId=s.nextLine();
		CustomerBo cbo=new CustomerBoImplementation();
		Customer customer=cbo.getCustomerById(customerId);
		if(customer!=null) {
			System.out.println(customer);
		}
		else {
			System.out.println("customer data not found");
		}
	}

	private static void registerCustomer() throws ParseException {
		Scanner s=new Scanner(System.in);
		Customer c=new Customer();
		System.out.println("Enter the customer number");
		c.setCustomerNumber(s.nextLine());
		System.out.println("Enter the customer first name");
		c.setFirstName(s.nextLine());
		System.out.println("Enter the customer middle name");
		c.setMiddleName(s.nextLine());
		System.out.println("Enter the customer last name");
		c.setLastname(s.nextLine());
		System.out.println("Enter the customer city name");
		c.setCity(s.nextLine());
		System.out.println("Enter the customer contact number");
		c.setContactNo(s.nextLine());
		System.out.println("Enter the customer occupation");
		c.setOccupation(s.nextLine());
		System.out.println("Enter the customer date of birth(YYYY-MM-DD)");
		String dob=s.nextLine();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		c.setDob(sdf.parse(dob));
		
		CustomerBo cbo=new CustomerBoImplementation();
		int status=cbo.addCustomer(c);
		if(status!=0) {
			System.out.println("Customer details registered successfull");
		}
		else {
			System.out.println("Customer details are not registered");
		}
	}
}
