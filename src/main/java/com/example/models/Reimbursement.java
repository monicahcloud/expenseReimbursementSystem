package com.example.models;

import java.sql.Timestamp;
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


@Entity
@Table(name="reimbursements")
public class Reimbursement {
	
	@Id
	@Column(name="reimb_id")
	private int reimb_id;
	
	@Column(name="reimb_amount", nullable=false)
	private int reimbAmount;
	
	@Column(name="reimb_submitted", nullable=true)
	private Timestamp reimbSubmitted;
	
	@Column(name="reimb_resolved", nullable=true)
	private Timestamp reimbResolved;
	
	@Column(name="reimb_description", nullable=false)
	private String reimbDescription;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "reimb_status_FK")
	private ReimbursementStatus status;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "reimb_type_FK")
	private ReimbursementType  type;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_reimb_FK")
	private User userReimb;


	public Reimbursement() {}
	
	public Reimbursement( int reimbAmount, String reimbDescription) {
		
		this.setReimb_id (new Random().nextInt(9000));
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		
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

	public ReimbursementStatus getReimbStatus() {
		return status;
	}

	public void setReimbStatus(ReimbursementStatus reimbStatus) {
		this.status = reimbStatus;
	}

	public ReimbursementType getReimbType() {
		return type;
	}

	public void setReimbType(ReimbursementType reimbType) {
		this.type = reimbType;
	}
	
	
	@Override
	public String toString() {
		return "Reimbursement [reimb_id=" + reimb_id + ", reimbAmount=" + reimbAmount + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbDescription=" + reimbDescription
				+ ", reimbStatus=" + status + ", reimbType=" + type + "]";
	}
	
	
	
}
