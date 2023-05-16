package com.mindtreebank.model;

import java.util.Date;

public class Customer {
	private String customerNumber;
	private String firstName;
	private String middleName;
	private String lastname;
	private String city;
	private String contactNo;
	private String occupation;
	private Date dob;
	
	public Customer() {
		
	}

	public Customer(String customerNumber, String firstName, String middleName, String lastname, String city,
			String contactNo, String occupation, Date dob) {
		super();
		this.customerNumber = customerNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastname = lastname;
		this.city = city;
		this.contactNo = contactNo;
		this.occupation = occupation;
		this.dob = dob;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Customer [customerNumber=" + customerNumber + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastname=" + lastname + ", city=" + city + ", contactNo=" + contactNo + ", occupation="
				+ occupation + ", dob=" + dob + "]";
	}
	
	
}
