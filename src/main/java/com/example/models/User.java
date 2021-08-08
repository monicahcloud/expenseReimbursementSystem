package com.example.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.SQLQuery;

import com.example.utils.HibernateUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties(value= {"hibernateLazyInitializer", "handler"})
@Table(name="ers_users")
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

	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="role_FK")
	private UserRole role;
	
	@JsonIgnore
	@OneToMany(mappedBy = "reimb_resolver", fetch = FetchType.LAZY)
	private List<Reimbursement> remList = new ArrayList<Reimbursement>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "reimb_author", fetch = FetchType.LAZY)
	private List<Reimbursement> reimList = new ArrayList<Reimbursement>();

	public User() {
//	reimbList = new ArrayList<Reimbursement>();
	}

	public User(String username) {
		
		this.username = username;
	}

	public User(String firstName, String lastName, String email, String password,  UserRole userRole) {
	
		this.setEmpNumber(new Random().nextInt(900)+100);
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = firstName + lastName + (new Random().nextInt(9000) + 1000);
		this.password = password;
		this.email = email;
		this.role = userRole;
		
	}

	public User(String firstName, String lastName, String password, String email, UserRole userRole, List<Reimbursement> reimbList) {
		this.setEmpNumber(new Random().nextInt(900)+100);
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = firstName + lastName + (new Random().nextInt(9000) + 1000);
		this.password = password;
		this.email = email;
		this.role = userRole;
	
	}

	public User(int empNumber, String firstName, String lastName, String username, String password, String email, UserRole userRole) {
		
		this.setEmpNumber(new Random().nextInt(900)+100);
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = firstName + lastName + (new Random().nextInt(9000) + 1000);
		this.password = password;
		this.email = email;
		this.role = userRole;

	}


	public User(int empNumber, String firstName, String lastName, String password, String email, UserRole userRole) {
		super();
		this.setEmpNumber(new Random().nextInt(900)+100);
		this.empNumber = empNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = firstName + lastName + (new Random().nextInt(9000) + 1000);
		this.password = password;
		this.email = email;
		this.role = userRole;
	}

	private  UserRole retrieveRole(int role_id) {
		String sql = "SELECT * FROM user_role WHERE employee_role =: role_id ";
		SQLQuery query = HibernateUtil.getSession().createSQLQuery(sql);
		query.addEntity(UserRole.class);
		query.setParameter("employee_role", role_id);
		List results = query.list();
		return (UserRole)results.get(0);
		
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

//	public List<Reimbursement> getReimbList() {
//		return reimbList;
//	}
//
//	public void setReimbList(List<Reimbursement> reimbList) {
//		this.reimbList = reimbList;
//	}

	public UserRole getUserRole() {
		return role;
	}

	public void setUserRole(UserRole userRole) {
		this.role = userRole;
	}
	
	
	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public List<Reimbursement> getRemList() {
		return remList;
	}

	public void setRemList(List<Reimbursement> remList) {
		this.remList = remList;
	}

	public List<Reimbursement> getReimList() {
		return reimList;
	}

	public void setReimList(List<Reimbursement> reimList) {
		this.reimList = reimList;
	}

	@Override
	public String toString() {
		return "User [empNumber=" + empNumber + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", email=" + email + ", role=" + role + "]";
	}

//	public List<Reimbursement> getReimbList() {
//		return reimbList;
//	}
//
//	public void setReimbList(List<Reimbursement> reimbList) {
//		this.reimbList = reimbList;
//	}

 		
}