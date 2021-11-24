package section3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SQLtest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = JDBCConnection.getJDBCConnection();
		
		try {
			Statement statement = conn.createStatement();
			
			final String sql = "SELECT * FROM user WHERE id =1";
			
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
//				int id= rs.getInt("id");
//				String name = rs.getString("name");
//				String username = rs.getString("username");
//				String password = rs.getString("password");
//				String role = rs.getString("role");
//				
//				System.out.println(id + " " + name + " " + username + " " + password + " " + role);
				
				String name = rs.getString("name");
				System.out.println(name);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
