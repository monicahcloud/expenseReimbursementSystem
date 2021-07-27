package com.example.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="users")
public class User {
	@Id
	@Column(name="employee_number")
	private int empNumber;
	
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="last_name", nullable=false)
	private String lastName;
	
	@Column(name="username", nullable=false, unique=true)
	private String username;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@Column(name="email", nullable=false, unique=true)
	private String email;
	
	@Column(name="role", nullable=false)
	private String role;
	
	private List<Reimbursement> reimb;
	
	public User() {
		setReimb(new ArrayList<Reimbursement>());
	}
	
	public User(String firstName, String lastName, String password, String email, String role) {
	
		this.setEmpNumber(new Random().nextInt(9000)+1000);
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = firstName + lastName + (new Random().nextInt(9000) + 1000);
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public User(int empNumber, String firstName, String lastName, String username, String password, String email, String role) {
		
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [empNumber=" + empNumber + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", email=" + email + ", role=" + role + "]";
	}

	public List<Reimbursement> getReimb() {
		return reimb;
	}

	public void setReimb(List<Reimbursement> reimb) {
		this.reimb = reimb;
	}

		
}
