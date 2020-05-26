package com.minibankapp.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLConnUtils {
	
	public MySQLConnUtils()
	{
		
	}
	  
	 public Connection getMySQLConnection()
	         throws ClassNotFoundException, SQLException {
	     // Note: Change the connection parameters accordingly.
	     String hostName = "127.0.0.1:3306";
	     String dbName = "minibankappdb";
	     String userName = "root";
	     String password = "12345678";
	     Class.forName("com.mysql.jdbc.Driver");
		  
	     String connectionURL = "jdbc:mysql://" + hostName + "/" + dbName;
	  
	     Connection conn = DriverManager.getConnection(connectionURL, userName,
	             password);
	     return conn;
	 }
	  
	
	}
