package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.models.User;
import com.example.models.UserRole;
import com.example.utils.ConnectionUtil;

public class UserDaoDB implements UserDao{
	
	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public List<User> getAllUsers() {
		
		List<User> userList = new ArrayList<User>();
		
		try {
			
			Connection con = conUtil.getConnection();
			
			String sql = "SELECT * FROM users";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				//userList.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
			}
			
		return userList;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@Override
	public User getUserByUserName(String username) {
		try {
			
			Connection con = conUtil.getConnection();
			
			String sql = "SELECT * FROM users WHERE username =?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			

			UserRole role;
			
			if(rs.getInt("USER_ROLE_ID")==2) {
				
				role = new UserRole("Employee");
				
			}else {
				role = new UserRole("Manager");
			}
			
			//return username;	

		return null;
		} catch (SQLException e) {
				e.printStackTrace();
				}
	}// end of getUserByUserName method
	
	

	@Override
	public void createUser(User u) throws SQLException {
		Connection con = conUtil.getConnection();
		String sql = "INSERT INTO users(employee_id, first_name, last_name, email, username, password) values"
				+ "(?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, u.getEmpNumber());
		ps.setString(2, u.getFirstName());
		ps.setString(3, u.getLastName());
		ps.setString(4, u.getEmail());
		ps.setString(5, u.getUsername());
		ps.setString(6, u.getPassword());
		//ps.setString(7, u.getRole());
			
		ps.execute();
		
	}

	@Override
	public void updateUser(User u) {
	
	}

	@Override
	public void deleteUser(User u) {
		
	}

}
