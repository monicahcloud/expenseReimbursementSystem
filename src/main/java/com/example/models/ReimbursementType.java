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
@Table(name="reimbursements_type")
public class ReimbursementType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	
	@Column(name="reimb_type")
	@OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
	private List<Reimbursement> reimbList = new ArrayList<Reimbursement>();
	
	private String reimbType;
	
	public ReimbursementType() {}

	public ReimbursementType(String reimbType) {
		
//		this.setId (new Random().nextInt(9000));
		this.reimbType = reimbType;
	}

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

	public String getReimbType() {
		return reimbType;
	}

	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}

	@Override
	public String toString() {
		return "ReimbursementType [reimbType=" + reimbType + "]";
	}
	
	
	
}
