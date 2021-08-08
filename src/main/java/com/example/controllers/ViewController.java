package com.example.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class ViewController {

	//JSON
	
	public static String fetchLoginPage(HttpServletRequest req) throws ServletException, IOException {
		System.out.println(req.getContentType());
		System.out.println("This should return the view landing.html");
		return "./html/landing.html";
	}
	
	public static String fetchEmployeePage(HttpServletRequest req) throws ServletException, IOException {
		System.out.println(req.getContentType());
		System.out.println("This should return the view EmployeeServices.html");
		return "./html/employeeServices.html";
		
	}
	
	public static String fetchManagerPage(HttpServletRequest req) throws ServletException, IOException {
		System.out.println(req.getContentType());
		System.out.println("This should return the view ManagerServices.html");
		return "./html/managerServices.html";
	}
	
}
