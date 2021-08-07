package com.example.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.UserDao;
import com.example.dao.UserDaoDB;
import com.example.models.User;
import com.example.services.UserServices;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.UserDao;
import com.example.dao.UserDaoDB;
import com.example.models.User;
import com.example.services.UserServices;

public class LoginViewController {
	
	public static String fetchLoginPage(HttpServletRequest req) throws ServletException, IOException {
		
		System.out.println(req.getContentType());
		System.out.println("This should return the view login.html");
		return "./html/login.html";
	}
}