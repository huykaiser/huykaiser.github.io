package section3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	public static Connection getJDBCConnection() {
		final String url = "jdbc:mysql://localhost:3306/databasesection3";
		final String user = "root";
		final String password = "123456789";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				return DriverManager.getConnection(url,user,password);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		Connection connection = getJDBCConnection();
		
		if(connection != null) {
			System.out.println("Succeed");
			
		} else {
			System.out.println("Failed");
		}
	}
}
