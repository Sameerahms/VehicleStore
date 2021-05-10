package com.hms.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

public static final  DatabaseConnection instancData = new DatabaseConnection();
	
	public static DatabaseConnection getInstance() {
		return instancData;
	}
	
	public static Connection getConnection() throws SQLException {
		Connection connection = null;
		
		//Localhost
		String dbUrl = "jdbc:mysql://localhost:3306/vehicle_store?useUnicode=yes&characterEncoding=UTF-8";
		String dbUser= "root";
		String dbPass= "";
		 		
		try{
			Class.forName ("com.mysql.jdbc.Driver").newInstance ();
			return DriverManager.getConnection(dbUrl, dbUser, dbPass);
			
		}catch(Exception e){	
			System.out.println("error// : "+e.toString());
		}
		
		System.out.println("*** CONNECTION ****"+connection);
		return connection;
	}
	
}
