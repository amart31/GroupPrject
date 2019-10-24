package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnFactory {
	//Singleton Factory
	
	//private static instance of itself
	private static ConnFactory cf = new ConnFactory();
	
	//private no args constructor
	private ConnFactory() {
		super();
	}
	
	//public static syncronized "getter" method
	public static synchronized ConnFactory getInstance() {
		if(cf == null) {
			cf = new ConnFactory();
		}
		return cf;
	}
	
	//Methods that do stuff
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:postgresql://dbbenright.cviba8ddmknh.us-east-2.rds.amazonaws.com/postgres";
		String user = "benright313";
		String pw = "awsDB313";
		try {
			conn = DriverManager.getConnection(url, user, pw);
		} catch (SQLException e) {
			System.out.println("Failed to create connection!");
			e.printStackTrace();
		}
		return conn;
	}
	
}
