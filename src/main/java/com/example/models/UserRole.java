package com.example.models;

import java.util.Random;

public class UserRole {

	private int employeeNumber;
	private String role;
	
	
	public UserRole() {}
	
		public UserRole( String role) {
		
		this.setEmployeeNumber(new Random().nextInt(9000)+1000);
		this.role = role;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRole [employeeNumber=" + employeeNumber + ", role=" + role + "]";
	}
	
	
	
}
