package com.example.models;

import java.util.Random;

public class ReimbursementStatus {
	
	
	private int id;
	private String reimbStatus;
	
	public ReimbursementStatus() {}
	
	
	public ReimbursementStatus(String reimbStatus) {
		
		this.setId(new Random().nextInt(9000));
		this.reimbStatus = reimbStatus;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "ReimbursementStatus [id=" + id + ", reimbStatus=" + reimbStatus + "]";
	}
	
	
	
	
}
