package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	//GET request to /login will forward the user to login.html
	protected void doGet(HttpServletRequest req, HttpServletResponse res ) throws IOException, ServletException{
	
	req.getRequestDispatcher("./html/login.html").forward(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		System.out.println(username);
		System.out.println(password);
		
		if (!username.equals(username) || !password.equals(password)) {
			res.sendRedirect("login");
			} else res.sendRedirect("employeeServices");
	}
	
}
