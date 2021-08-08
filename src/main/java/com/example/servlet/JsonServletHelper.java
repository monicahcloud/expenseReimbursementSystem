package com.example.servlet;

import java.io.IOException;
import com.example.controllers.LoginController;
import com.example.controllers.ReimbursementsController;
import com.example.controllers.LogoutController;
import com.example.controllers.SessionController;
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
		case "/ExpenseReimbursementSystem/api/logout":
			System.out.println("I am in switch statement case 2 in JsonHelper");
			LogoutController.logout(req, res);
			break;
		case "/ExpenseReimbursementSystem/api/reimbursements":
			System.out.println("I am in switch statement case 3 in JsonHelper");
			ReimbursementsController.handleReimbursements(req, res);
			break;
		case "/ExpenseReimbursementSystem/api/session":
			System.out.println("I am in switch statement case 4 in JsonHelper");
			SessionController.getSession(req, res); 
			break;
		case "/ExpenseReimbursementSystem/api/addnewReimbursement":
			System.out.println("I am in switch statement case 5 in JsonHelper");
			ReimbursementsController.addnewReimbursement(req, res);
			break;
	}
	}
}