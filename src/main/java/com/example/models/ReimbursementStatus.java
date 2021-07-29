package com.example.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="reimbursements_status")
public class ReimbursementStatus {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	
	@Column(name="reimb_status")
	@OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
	private List<Reimbursement> reimbList = new ArrayList<Reimbursement>();
	
	private String reimbStatus;
	
	public ReimbursementStatus() {}
	
	
	public ReimbursementStatus(String reimbStatus) {
		
	this.reimbStatus = reimbStatus;
	}


	@Override
	public String toString() {
		return "ReimbursementStatus [reimbStatus=" + reimbStatus + "]";
	}
	
		
}
