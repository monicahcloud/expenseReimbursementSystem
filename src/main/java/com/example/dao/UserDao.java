package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.models.User;

public interface UserDao {

	List<User> getAllUsers();
	
	User getUserByUserName(String username);
	
	void createUser(User u) throws SQLException;
	
	void updateUser(User u) throws SQLException;
	
	void deleteUser(User u) throws SQLException;
	
	
}
