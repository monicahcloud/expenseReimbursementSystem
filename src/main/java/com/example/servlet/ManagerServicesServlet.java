package com.example.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManagerServicesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//GET request to /login will forward the user to login.html
	protected void doGet(HttpServletRequest req, HttpServletResponse res ) throws IOException, ServletException{
			req.getRequestDispatcher("./html/managerServices.html").forward(req, res);
}
}
