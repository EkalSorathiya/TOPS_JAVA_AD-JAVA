package com.util;

import java.sql.Connection;

import java.sql.DriverManager;

import com.mysql.cj.jdbc.Driver;

public class ProjectUtil {
	
	public static Connection createConnection() 
	{
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/tops","root","");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
