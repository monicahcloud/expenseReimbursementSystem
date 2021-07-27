package com.example.models;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="reimbursements")
public class Reimbursement {
	
	@Id
	@Column(name="reimb_id")
	private int reimb_id;
	
	@Column(name="reimb_amount", nullable=false)
	private double reimbAmount;
	
	@Column(name="reimb_submitted", nullable=false)
	private Timestamp reimbSubmitted;
	
	@Column(name="reimb_resolved", nullable=false, unique=true)
	private Timestamp reimbResolved;
	
	@Column(name="reimb_description", nullable=false, unique=true)
	private String reimbDescription;
	
	@Column(name="reimb_receipt", nullable=false, unique=true)
	private String reimbReceipt;
	
	@Column(name="reimb_status", nullable=false, unique=true)
	private String reimbStatus;
	
	@Column(name="reimb_type", nullable=false, unique=true)
	private String reimbType;
	
	private List<User> userList;
	
	
	
	public Reimbursement() {}
	
	public Reimbursement( double reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved,
			String reimbDescription, String reimbReceipt) {
		
		this.setReimb_id (new Random().nextInt(9000));
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.reimbReceipt = reimbReceipt;
	}

	public int getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public double getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public Timestamp getReimbSubmitted() {
		return reimbSubmitted;
	}

	public void setReimbSubmitted(Timestamp reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}

	public Timestamp getReimbResolved() {
		return reimbResolved;
	}

	public void setReimbResolved(Timestamp reimbResolved) {
		this.reimbResolved = reimbResolved;
	}

	public String getReimbDescription() {
		return reimbDescription;
	}

	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}

	public String getReimbReceipt() {
		return reimbReceipt;
	}

	public void setReimbReceipt(String reimbReceipt) {
		this.reimbReceipt = reimbReceipt;
	}
	

	public String getReimbStatus() {
		return reimbStatus;
	}

	public void setReimbStatus(String reimbStatus) {
		this.reimbStatus = reimbStatus;
	}

	public String getReimbType() {
		return reimbType;
	}

	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}
	
	

	@Override
	public String toString() {
		return "Reimbursement [reimb_id=" + reimb_id + ", reimbAmount=" + reimbAmount + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbDescription=" + reimbDescription
				+ ", reimbReceipt=" + reimbReceipt + ", reimbStatus=" + reimbStatus + ", reimbType=" + reimbType + "]";
	}
	
	
	
}
