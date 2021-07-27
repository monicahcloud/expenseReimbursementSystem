package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.models.Reimbursement;
import com.example.models.User;

public interface ReimbursementDao {

	List<Reimbursement> getAllReimbursement();
	
	public List<Reimbursement> getUserReimbursement(User u);
	
	Reimbursement getReimbursementByUser(User u);
	
	void createReimb(User u) throws SQLException;
	
	void updateReimb(User u) throws SQLException;
	
	void deleteReimb(User u) throws SQLException;
	
	
}
