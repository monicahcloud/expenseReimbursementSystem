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
	@Column(name="type_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="reimb_type")
	private String type;
	

	@OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
	private List<Reimbursement> reimbList = new ArrayList<Reimbursement>();
	
	
	public ReimbursementType() {}

	public ReimbursementType(String type) {

		this.type = type;
	}

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

	public String getReimbType() {
		return type;
	}

	public void setReimbType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ReimbursementType [type=" +type + "]";
	}
	
	
	
}
