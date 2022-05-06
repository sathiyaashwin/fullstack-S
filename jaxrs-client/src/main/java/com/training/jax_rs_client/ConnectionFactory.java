package com.training.jax_rs_client;

import java.sql.*;
import java.util.ResourceBundle;

public class ConnectionFactory {
	
	public static Connection getOracleConnection(){
		
		Connection con =null;
		
		try {
			ResourceBundle labels = ResourceBundle.getBundle("application");
			
			con = DriverManager.getConnection(labels.getString("datasource.oracle.url"),labels.getString("datasource.oracle.username"),labels.getString("datasource.oracle.password"));
		
			} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	public Connection getPostgressConnection(){
		
		return null;
		
	}
}
