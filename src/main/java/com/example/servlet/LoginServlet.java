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
		//RequestDispatcher will forward method to serve a static web page to the client
//		PrintWriter pw = res.getWriter();
//		System.out.println("We made it to the simple text servlet");
//		pw.println("login.html");
	req.getRequestDispatcher("./html/login.html").forward(req, res);
	}
}
