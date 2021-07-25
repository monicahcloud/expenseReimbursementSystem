package com.example.models;

import java.sql.Timestamp;
import java.util.Random;

public class Reimbursement {
	
	private int reimb_id;
	private double reimbAmount;
	private Timestamp reimbSubmitted;
	private Timestamp reimbResolved;
	private String reimbDescription;
	private String reimbReceipt;
	private ReimbursementStatus reimbStatus;
	private ReimbursementType reimbType;
	
	
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
	

	public ReimbursementStatus getReimbStatus() {
		return reimbStatus;
	}

	public void setReimbStatus(ReimbursementStatus reimbStatus) {
		this.reimbStatus = reimbStatus;
	}

	public ReimbursementType getReimbType() {
		return reimbType;
	}

	public void setReimbType(ReimbursementType reimbType) {
		this.reimbType = reimbType;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimb_id=" + reimb_id + ", reimbAmount=" + reimbAmount + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbDescription=" + reimbDescription
				+ ", reimbReceipt=" + reimbReceipt + "]";
	}
	
	
	
}
