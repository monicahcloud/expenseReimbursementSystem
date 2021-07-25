package com.example.models;

import java.util.Random;

public class ReimbursementType {
	
	private int id;
	private String reimbType;
	
	public ReimbursementType() {}

	public ReimbursementType(String reimbType) {
		
		this.setId (new Random().nextInt(9000));
		this.reimbType = reimbType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReimbType() {
		return reimbType;
	}

	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}

	@Override
	public String toString() {
		return "ReimbursementType [id=" + id + ", reimbType=" + reimbType + "]";
	}
	
	
	
}
