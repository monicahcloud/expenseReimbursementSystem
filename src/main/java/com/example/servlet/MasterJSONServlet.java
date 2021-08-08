package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MasterJSONServlet  extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res ) throws IOException, ServletException{
		System.out.print("I am in the MasterSerlve doGet method");
		JsonServletHelper.process(req, res);
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res ) throws IOException, ServletException{
		System.out.print("I am in the MasterSerlve doPost method");
		JsonServletHelper.process(req, res);
		
	}

}