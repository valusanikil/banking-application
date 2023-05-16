package com.mindtreebank.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection createConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/mindtreebank?useSSL=false";
		String user = "root";
		String password = "123456";
		Connection con= DriverManager.getConnection(url, user, password);
		return con;
	}
}
