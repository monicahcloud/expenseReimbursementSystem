package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.models.Reimbursement;
import com.example.models.User;

public interface ReimbursementDao {
	
	List<Reimbursement> selectAllReimb();
	
	Reimbursement getReimbursementByStatus();
	
	void updateReimb(Reimbursement r) ;
	
	void deleteReimb(Reimbursement r);
	
	void submitReimb(Reimbursement r);
	
	Reimbursement selectReimbById(int reimb_id);
	
	public List<Reimbursement> selectResolved();
	
	public List<Reimbursement> selectPending();
	
}
