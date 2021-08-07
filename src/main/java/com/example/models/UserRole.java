package com.example.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value= {"hibernateLazyInitializer", "handler"})
@Table(name="user_role")
public class UserRole {

	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	
	@Column(name="employee_role")
	private String role;
	
	@JsonBackReference
	@JsonIgnore
	@OneToMany(mappedBy = "role", fetch=FetchType.LAZY)
	private List<User> uList = new ArrayList<User>();
	
	
	public UserRole() {}
	
		public UserRole( int id, String role) {
		this.id=id;
		this.role = role;
	}

	public UserRole(String role) {
			super();
			this.role = role;
		}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRole [role=" + role + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<User> getuList() {
		return uList;
	}

	public void setuList(List<User> uList) {
		this.uList = uList;
	}
	
	
	
}
