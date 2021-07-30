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
	@Column(name="status_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="reimb_status")
	private String status;
	
	@OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
	private List<Reimbursement> reimbList = new ArrayList<Reimbursement>();
	
	
	public ReimbursementStatus() {}
	
	
	public ReimbursementStatus(String reimbStatus) {
		
	this.status = status;
	}


	@Override
	public String toString() {
		return "ReimbursementStatus [status=" + status + "]";
	}
	
		
}
