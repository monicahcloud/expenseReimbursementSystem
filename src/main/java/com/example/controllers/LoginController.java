package com.example.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.UserDao;
import com.example.dao.UserDaoDB;

import com.example.models.User;
import com.example.services.UserServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class LoginController {

	private static UserDao uDao = new UserDaoDB();
	private static UserServices uServ = new UserServices(uDao);
	
	
	public static void login(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		//putting data in JSON readable format
		StringBuilder buffer = new StringBuilder();
		BufferedReader reader = req.getReader();
		
		String line;
		while((line = reader.readLine()) != null) {
			buffer.append(line);
			buffer.append(System.lineSeparator());
		}
		
		String data = buffer.toString();
		System.out.println(data);
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode parsedObj = mapper.readTree(data);
		
		String username = parsedObj.get("username").asText();
		String password = parsedObj.get("password").asText();
		
		//login
		try {
			System.out.println("In the login attempt");
			User u = uServ.login(username, password);
			int id = u.getEmpNumber();
			int role = u.getUserRole().getId();
			System.out.println(u);
			//We will keep track of if the user is logged in by storing their username in the session
			req.getSession().setAttribute("employee_number", id);
			req.getSession().setAttribute("userRole", role);
			res.setStatus(HttpServletResponse.SC_OK);
			res.addHeader("Access-Control-Allow-Origin", "*");
			res.setHeader("Access-Control-Allow-Methods", "POST");
			
			ObjectNode user = mapper.createObjectNode();
			
			user.put("employee_number", id);
			user.put("userRole", role);
			res.getWriter().write(new ObjectMapper().writeValueAsString(user));
			//res.getWriter().println("User signed in!");

		}
		catch(Exception e) {
			e.printStackTrace();
			res.setStatus(HttpServletResponse.SC_FORBIDDEN);
			res.getWriter().println("Username or password incorrect");
		}}}