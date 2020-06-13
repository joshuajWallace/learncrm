package jjw.project.crmlearn;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectionTest {
	public static void main(String[] args) {
		System.out.println("test");
		// setup connection variables
		String user = "springstudent";
		String pass = "springstudent";
		
		String jdbcUrl = "jdbc:mysql://192.168.99.100:3306/web_customer_tracker?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		// get connection to database
		try {
			
			Class.forName(driver);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("SUCCESS!!!");
			
			myConn.close();
			
		}
		catch (Exception exc) {
			System.out.println("false");
			exc.printStackTrace();
		}
	}

}
