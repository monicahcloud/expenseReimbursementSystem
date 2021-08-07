package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.controllers.LoginViewController;

public class RequestViewHelper {
	public static String process(HttpServletRequest req) throws IOException, ServletException{
		
		System.out.println("In the view request helper process method, with URI: " + req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/ExpenseReimbursementSystem/login" :
			System.out.println("This is a test1");
			return LoginViewController.fetchLoginPage(req);
			
		case "/ExpenseReimbursementSystem/employeeServices" :
			System.out.println("This is a test1");
			return LoginViewController.fetchLoginPage(req);
			
		case "/ExpenseReimbursementSystem/managerServices" :
			System.out.println("This is a test1");
			return LoginViewController.fetchLoginPage(req);
			
		case "/ExpenseReimbursementSystem/landing" :
			System.out.println("This is a test1");
			return LoginViewController.fetchLoginPage(req);
			
		}System.out.println("This is a test2");
		return "/ExpenseReimbursementSystem/api/landing";
	}
}




