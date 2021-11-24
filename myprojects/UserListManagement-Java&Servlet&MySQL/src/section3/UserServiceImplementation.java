package section3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserServiceImplementation implements UserService{

	@Override
	public void insert(User user) {
		Connection connection = JDBCConnection.getJDBCConnection();
		
		String sql = "insert into user (name, username, password, role) values (?,?,?,?)";
		
		try{
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getRole());
			
			ps.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(User user) {
		Connection connection = JDBCConnection.getJDBCConnection();
		
		String sql = "Update user set name = ?, username = ?, password = ?, role = ? where id= ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getRole());
			ps.setInt(5, user.getId());
			
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		Connection connection = JDBCConnection.getJDBCConnection();
		
		String sql = "delete from user where id =?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public User get(int id){
		Connection connection = JDBCConnection.getJDBCConnection();
		
		String sql = "select * from user where id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			// get data from table 'user'
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				return rowMap(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	private User rowMap(ResultSet rs) throws SQLException {
		User user = new User();
		
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setRole(rs.getString("role"));
		
		
		return user;
	}

	@Override
	public List<User> search(String name) {
		List<User> users = new ArrayList<>();
		
		Connection connection = JDBCConnection.getJDBCConnection();
		
		String sql = "select * from user where name like ?";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, "%" + name + "%");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				users.add(rowMap(rs));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}

	@Override
	public List<User> getAll() {
		List<User> users = new ArrayList<>();
		
		Connection connection = JDBCConnection.getJDBCConnection();
		
		String sql = "select * from user";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				users.add(rowMap(rs));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}

}
