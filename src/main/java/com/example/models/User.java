package com.example.models;

import java.util.Random;

public class User {

	private int empNumber;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private UserRole role;
	
	public User() {}
	
	public User(String firstName, String lastName, String password, String email, UserRole role) {
	
		this.setEmpNumber(new Random().nextInt(9000)+1000);
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = firstName + lastName + (new Random().nextInt(9000) + 1000);
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public User(int empNumber, String firstName, String lastName, String username, String password, String email, UserRole role) {
		
		this.setEmpNumber(new Random().nextInt(9000)+1000);
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = firstName + lastName + (new Random().nextInt(9000) + 1000);
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public int getEmpNumber() {
		return empNumber;
	}

	public void setEmpNumber(int empNumber) {
		this.empNumber = empNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [empNumber=" + empNumber + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", email=" + email + "]";
	}

	
	
	
}
