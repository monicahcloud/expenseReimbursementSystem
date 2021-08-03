package com.example.servlet;

import java.io.IOException;
import com.example.controllers.LoginController;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;

public class JsonServletHelper {
	public static void process(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException, JsonProcessingException{
		
		System.out.println("In the JsonServletHelper with you URI: " +  req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/ExpenseReimbursementSystem/api/login":
			System.out.println("I am in switch statement case 1 in JsonHelper");
			LoginController.login(req, res);
			break;
//		case "/ExpenseReimbursementSystem/api/logout":
//			LogoutController.logout(req, res);
//			break;
//		case "/ExpenseReimbursementSystem/api/posts":
//			PostsController.handlePosts(req, res);
//			break;
//		case "/ExpenseReimbursementSystem/api/session":
//			SessionController.getSession(req, res);
//			break;
	}
	}
}
