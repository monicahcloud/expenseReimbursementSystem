package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.models.Reimbursement;
import com.example.models.User;

public interface ReimbursementDao {
	
	void addReimb(Reimbursement r) throws SQLException;
	
	List<Reimbursement> getAllReimbursement();
	
	Reimbursement getReimbursementByUser(User u);
	
	void updateReimb(Reimbursement r) ;
	
	void deleteReimb(Reimbursement r);
	
	public List<Reimbursement> getUserReimbursement(Reimbursement r);;
	
}
