package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public static final String className="com.mysql.cj.jdbc.Driver";
	public static final String dbUsername="root";
	public static final String dbPassword="1234";
	public static final String connection="jdbc:mysql://localhost:3306/blood_donor_system?autoReconnect=true&useSSL=false";
	

	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(className);
			conn= DriverManager.getConnection(connection,dbUsername,dbPassword);
		
		} catch(SQLException | ClassNotFoundException e) {
			System.out.println(e.toString());
		}
		return conn;
	}
	
	
}
