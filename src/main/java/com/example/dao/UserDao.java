package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.models.User;

public interface UserDao {
	
	
	void addUser(User u) throws SQLException;
	
	public User getUserByEmployeeNumber(int employee_number);
	
	void updateUser(User u);
	
	List<User> getAllUsers();
	
	User getUserByUserName(String username);
	
		
	void deleteUser(User u) throws SQLException;
	
	
}
