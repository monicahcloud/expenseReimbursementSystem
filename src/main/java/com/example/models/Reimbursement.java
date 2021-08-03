package com.example.models;


import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties(value= {"hibernateLazyInitializer", "handler"})
@Table(name="reimbursements")
public class Reimbursement {
	
	@Id
	@Column(name="reimb_id")
	private int reimb_id;
	
	@Column(name="reimb_amount", nullable=false)
	private int reimbAmount;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="reimb_submitted", nullable=true)
	private Date reimbSubmitted;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="reimb_resolved", nullable=true)
	private Date reimbResolved;
	
	@Column(name="reimb_description", nullable=false)
	private String reimbDescription;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "reimb_status_FK")
	private ReimbursementStatus status;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "reimb_type_FK")
	private ReimbursementType  type;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "reimb_author", referencedColumnName = "employee_number")
	private User reimb_author;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="reimb_resolver",  referencedColumnName = "employee_number")
	private User reimb_resolver;
	
//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name = "user_reimb_FK")
//	private User userReimb;


	public Reimbursement() {}
	
	public Reimbursement( int reimbAmount, String reimbDescription) {
		
		this.setReimb_id (new Random().nextInt(900)+100);
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		
	}
	
	

	public Reimbursement( int reimbAmount, 	String reimbDescription, ReimbursementStatus status, ReimbursementType type) {
		
		this.setReimb_id (new Random().nextInt(900)+100);
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.status = status;
		this.type = type;
	}
	
	
	public Reimbursement( int reimbAmount, Date reimbSubmitted, Date reimbResolved,
			String reimbDescription, ReimbursementStatus status, ReimbursementType type, User reimb_author,
			User reimb_resolver) {
		
		this.setReimb_id (new Random().nextInt(900)+100);
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.status = status;
		this.type = type;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
	}
	
	
	
	public Reimbursement(int reimbAmount, String reimbDescription, ReimbursementStatus status, ReimbursementType type,
			User reimb_author, User reimb_resolver) {
		super();
		this.setReimb_id (new Random().nextInt(900)+100);
		this.reimbAmount = reimbAmount;
		this.reimbDescription = reimbDescription;
		this.status = status;
		this.type = type;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
	}

	public Reimbursement(int reimb_id, int reimbAmount, Date reimbSubmitted, Date reimbResolved,
			String reimbDescription, ReimbursementStatus status, ReimbursementType type, User reimb_author,
			User reimb_resolver) {
		
		this.setReimb_id (new Random().nextInt(900)+100);
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.status = status;
		this.type = type;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
	}

	public int getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public int getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(int reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public Date getReimbSubmitted() {
		return reimbSubmitted;
	}

	public void setReimbSubmitted(Date reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}

	public Date getReimbResolved() {
		return reimbResolved;
	}

	public void setReimbResolved(Date reimbResolved) {
		this.reimbResolved = reimbResolved;
	}

	public String getReimbDescription() {
		return reimbDescription;
	}

	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}

	public ReimbursementStatus getStatus() {
		return status;
	}

	public void setStatus(ReimbursementStatus status) {
		this.status = status;
	}

	public ReimbursementType getType() {
		return type;
	}

	public void setType(ReimbursementType type) {
		this.type = type;
	}

	public User getReimb_author() {
		return reimb_author;
	}

	public void setReimb_author(User reimb_author) {
		this.reimb_author = reimb_author;
	}

	public User getReimb_resolver() {
		return reimb_resolver;
	}

	public void setReimb_resolver(User reimb_resolver) {
		this.reimb_resolver = reimb_resolver;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimb_id=" + reimb_id + ", reimbAmount=" + reimbAmount + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbDescription=" + reimbDescription
				+ ", status=" + status + ", type=" + type + ", reimb_author=" + reimb_author + ", reimb_resolver="
				+ reimb_resolver + "]";
	}//end of toString
		
	
}// end of class
