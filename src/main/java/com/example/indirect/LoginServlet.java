package com.example.indirect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	//GET request to /login will forawd the user to login.html
	protected void doGet(HttpServletRequest req, HttpServletResponse res ) throws IOException, ServletException{
		//RequestDispatcher will forward method to serve a static webpage to the client
		req.getRequestDispatcher("login.html").forward(req, res);
	}
}
