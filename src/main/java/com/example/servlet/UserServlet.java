package com.example.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.models.User;
import com.example.models.UserRole;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		res.setContentType("application/json");
		

		UserRole uR1 = new UserRole(1, "EMPLOYEE");
		UserRole uR2 = new UserRole(2, "MANAGER");
		
		User u = new User("Jane", "Doe", "password", "jane@gmail.com", uR2);
		User u1 = new User("Joe", "Doe", "password", "john@gmail.com", uR1);
		User u2 = new User("Jennifer", "Hudson", "password", "givingmyself@gmail.com", uR2);
		
		ArrayList<User> uList = new ArrayList<User>();
		uList.add(u1);
		uList.add(u2);
		uList.add(u);
		
		res.getWriter().write(new ObjectMapper().writeValueAsString(uList));
		
	}

}
