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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value= {"hibernateLazyInitializer", "handler"})
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
	
	
	public ReimbursementStatus(int id, String status) {
	this.id = id;	
	this.status = status;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public List<Reimbursement> getReimbList() {
		return reimbList;
	}


	public void setReimbList(List<Reimbursement> reimbList) {
		this.reimbList = reimbList;
	}


	@Override
	public String toString() {
		return "ReimbursementStatus [id=" + id + ", status=" + status + ", reimbList=" + reimbList + "]";
	}
	
	
	
		
}
