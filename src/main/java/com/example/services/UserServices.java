package com.example.services;

import java.sql.SQLException;

import com.example.dao.UserDao;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UserDoesNotExistException;
import com.example.exceptions.UserNameNotAvailable;
import com.example.logging.Logging;
import com.example.models.User;
import com.example.models.UserRole;

public class UserServices {

	private UserDao uDao;
	
	public UserServices() {}
	
	public UserServices(UserDao uDao) {
		this.uDao = uDao;
	}
	
	
	
	public User login (String username, String password) {
	
	User u = uDao.getUserByUserName(username);
	
	if(u.getUsername()== null) {
		Logging.logger.warn("User tried logging in that does not exist");
		throw new UserDoesNotExistException();
	}
	
	if(!u.getPassword().equals(password)) {
		Logging.logger.warn("User tried to login with invalid credentials");
		throw new InvalidCredentialsException();
	
	}else
	
	{
		Logging.logger.info("User was logged in");
		return u;
	}
}//end of login
	
	
	public User signUp(String firstName, String lastName, String password, String email, UserRole userRole) throws UserNameNotAvailable {
		
		User u = new User(firstName, lastName, password, email, userRole);
	
		try {
			uDao.addUser(u);
			Logging.logger.info("New user has registered");
			
		} catch (SQLException e) {
			Logging.logger.warn("Username created that already exists in the database");
			throw new UserNameNotAvailable();
		}
		 
		return u;
}// end of signUp
	public User getUserById(int employee_number) {
		return uDao.getUserByEmployeeNumber(employee_number);
	}

}//end of class

