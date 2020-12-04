package application.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static Connection connection=null;
	
	public DBConnection() {}
	
	public static Connection getConnection() {
		
		try {
			if(connection==null) {
//				Class.forName("com.mysql.jdbc.Driver");
				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Book","root","Succes0512");
			}
			
		} catch (Exception el) {
			// TODO: handle exception
		}
		return connection;
	
	}
}
