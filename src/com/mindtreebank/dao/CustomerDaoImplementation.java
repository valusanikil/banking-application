package com.mindtreebank.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mindtreebank.bo.CustomerBo;
import com.mindtreebank.bo.CustomerBoImplementation;
import com.mindtreebank.config.DBUtil;
import com.mindtreebank.model.Customer;

public class CustomerDaoImplementation implements CustomerDao {

	@Override
	public int addCustomer(Customer customer) {
		String insertQuery = "INSERT INTO customer_master VALUES(?,?,?,?,?,?,?,?)";
		int status = 0;
		try (Connection con = DBUtil.createConnection();
				PreparedStatement pstmt = con.prepareStatement(insertQuery);) {
				pstmt.setString(1, customer.getCustomerNumber());
				pstmt.setString(2, customer.getFirstName());
				pstmt.setString(3, customer.getMiddleName());
				pstmt.setString(4, customer.getLastname());
				pstmt.setString(5, customer.getCity());
				pstmt.setString(6, customer.getContactNo());
				pstmt.setString(7, customer.getOccupation());
				Date d=new Date(customer.getDob().getTime());
				pstmt.setDate(8, d);
				
				status=pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Customer> getAllCustomers() {
		String query="SELECT * FROM customer_master";
		List<Customer> list=new ArrayList<>();
		Customer c=null;
		try (Connection con = DBUtil.createConnection();
				PreparedStatement pstmt = con.prepareStatement(query)) {
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				c=new Customer();
				c.setCustomerNumber(rs.getString(1));
				c.setFirstName(rs.getString(2));
				c.setMiddleName(rs.getString(3));
				c.setLastname(rs.getString(4));
				c.setCity(rs.getString(5));
				c.setContactNo(rs.getString(6));
				c.setOccupation(rs.getString(7));
				c.setDob(rs.getDate(8));
				list.add(c);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Customer getCustomerById(String customerId) {
		String query="SELECT * FROM customer_master WHERE CUSTOMER_NUMBER=?";
		Customer c=new Customer();
		try (Connection con=DBUtil.createConnection();
				PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setString(1, customerId);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				c.setCustomerNumber(rs.getString(1));
				c.setFirstName(rs.getString(2));
				c.setMiddleName(rs.getString(3));
				c.setLastname(rs.getString(4));
				c.setCity(rs.getString(5));
				c.setContactNo(rs.getString(6));
				c.setOccupation(rs.getString(7));
				c.setDob(rs.getDate(8));
			}
			else {
				c=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public int DeleteCustomerById(String customerId) {
		String url = "jdbc:mysql://localhost:3306/mindtreebank?useSSL=false";
		String user = "root";
		String password = "123456";
		String query="DELETE FROM customer_master WHERE CUSTOMER_NUMBER=?";
		int result=0;
		try (Connection con = DriverManager.getConnection(url,user,password);
				PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setString(1, customerId);
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		String url = "jdbc:mysql://localhost:3306/mindtreebank?useSSL=false";
		String user = "root";
		String password = "123456";
		String query="UPDATE customer_master SET FIRSTNAME=?,middlename=?,lastname=?,CUSTOMER_CITY=?,"
				+ "CUSTOMER_CONTACT_NO=?,occupation=?,CUSTOMER_DATE_OF_BIRTH=? "
				+ "WHERE CUSTOMER_NUMBER=?";
		Customer cust=null;
		try (Connection con = DriverManager.getConnection(url,user,password);
				PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setString(1, customer.getFirstName());
			pstmt.setString(2, customer.getMiddleName());
			pstmt.setString(3, customer.getLastname());
			pstmt.setString(4, customer.getCity());
			pstmt.setString(5, customer.getContactNo());
			pstmt.setString(6, customer.getOccupation());
			Date date=new Date(customer.getDob().getTime());
			pstmt.setDate(7, date);
			pstmt.setString(8, customer.getCustomerNumber());
			int result=pstmt.executeUpdate();
			if(result!=0) {
				cust=getCustomerById(customer.getCustomerNumber());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cust;
	}

	@Override
	public Customer updateCustomerById(String customerId) {
		Scanner s=new Scanner(System.in);
		Customer customer=new Customer();
		System.out.println("Enter the customer new first name");
		customer.setFirstName(s.nextLine());
		System.out.println("Enter the customer new middle name");
		customer.setMiddleName(s.nextLine());
		System.out.println("Enter the customer new last name");
		customer.setLastname(s.nextLine());
		System.out.println("Enter the customer new city name");
		customer.setCity(s.nextLine());
		System.out.println("Enter the customer new contact number");
		customer.setContactNo(s.nextLine());
		System.out.println("Enter the customer new occupation");
		customer.setOccupation(s.nextLine());
		System.out.println("Enter the customer new date of birth(YYYY-MM-DD)");
		String dob=s.nextLine();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			customer.setDob(sdf.parse(dob));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/mindtreebank?useSSL=false";
		String user = "root";
		String password = "123456";
		String query="UPDATE customer_master SET FIRSTNAME=?,middlename=?,lastname=?,CUSTOMER_CITY=?,"
				+ "CUSTOMER_CONTACT_NO=?,occupation=?,CUSTOMER_DATE_OF_BIRTH=? WHERE CUSTOMER_NUMBER=?";
		try (Connection con = DriverManager.getConnection(url,user,password);
				PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setString(1, customer.getFirstName());
			pstmt.setString(2, customer.getMiddleName());
			pstmt.setString(3, customer.getLastname());
			pstmt.setString(4, customer.getCity());
			pstmt.setString(5, customer.getContactNo());
			pstmt.setString(6, customer.getOccupation());
			Date date=new Date(customer.getDob().getTime());
			pstmt.setDate(7, date);
			pstmt.setString(8, customerId);
			int result=pstmt.executeUpdate();
			if(result!=0) {
				return customer;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
