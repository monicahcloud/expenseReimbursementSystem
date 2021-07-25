package com.example.dao;

import java.util.List;

import com.example.models.User;

public interface Reimbursement {

	List<Reimbursement> getAllReimbursement();
	
	public List<Reimbursement> getUserReimbursement(User u);
	
	Reimbursement getReimbursementByUser(User u);
	
}
