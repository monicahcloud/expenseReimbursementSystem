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
			
			String sql = "SELECT * FROM ers_users";
			
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
		
		User u= new User();
		
		try {
			
			Connection con = conUtil.getConnection();
			String sql = "SELECT * FROM ers_users WHERE ers_users.username = '" + username + "'";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			

//			UserRole role;
//			
//			if(rs.getInt("USER_ROLE_ID")==2) {
//				
//				role = new UserRole("Employee");
//				
//			}else {
//				role = new UserRole("Manager");
//			}
			
			return u;	

		} catch (SQLException e) {
				e.printStackTrace();
				}
		return null;
	}// end of getUserByUserName method
	
	

	@Override
	public void createUser(User u) throws SQLException {
		
		
		Connection con = conUtil.getConnection();
		String sql = "INSERT INTO ers_users(employee_id, first_name, last_name,  username, password, email_address, employee_role) values"
				+ "(?,?,?,?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt (1, u.getEmpNumber());
		ps.setString(2, u.getFirstName());
		ps.setString(3, u.getLastName());
		ps.setString(5, u.getUsername());
		ps.setString(6, u.getPassword());
		ps.setString(4, u.getEmail());
		ps.setString(7, u.getRole());
			
		ps.execute();
		
	}

	@Override
	public void updateUser(User u) throws SQLException {
		
		try {
	
		Connection con = conUtil.getConnection();
		String sql = "UPDATE ers_users SET first_name = ?, last_name = ?, email = ?, username = ?, password = ? " + "WHERE employee_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, u.getFirstName());
		ps.setString(2, u.getLastName());
		ps.setString(3, u.getEmail());
		ps.setString(4, u.getUsername());
		ps.setString(5, u.getPassword());
		ps.setInt(6, u.getEmpNumber());
		
		ps.execute();
		
	} catch(SQLException e) {
		e.printStackTrace();
	}
	}
	
	
	
	@Override
	public void deleteUser(User u) {
		
try {
			
			Connection con = conUtil.getConnection();
			String sql = "DELETE FROM ers_users WHERE ers_users.employee_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, u.getEmpNumber());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
