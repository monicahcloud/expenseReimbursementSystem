package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MasterJSONServlet  extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res ) throws IOException, ServletException{
		JsonServletHelper.process(req, res);
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res ) throws IOException, ServletException{
		JsonServletHelper.process(req, res);
		
	}

}
