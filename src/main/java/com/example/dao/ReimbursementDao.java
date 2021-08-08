package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.models.Reimbursement;
import com.example.models.ReimbursementStatus;
import com.example.models.ReimbursementType;
import com.example.models.User;

public interface ReimbursementDao {
	
	List<Reimbursement> selectAllReimb();
	
	//ReimbursementStatus retrieveStatus();
	
	Reimbursement updateReimb(Reimbursement r) ;
	
	void deleteReimb(Reimbursement r);
	
	void addReimb(Reimbursement r);
	
	Reimbursement selectReimbById(int reimb_id);
	
	public List<Reimbursement> selectResolved();
	
	public List<Reimbursement> selectPending();
	
	ReimbursementType retrieveType(String rType);

	User getUserByUsername(String username);
	
List<Reimbursement> getAllPendingReimbursmentsForUser(User u);
	
	List<Reimbursement> getAllAcceptedReimbursmentsForUser(User u);
	
	List<Reimbursement> getAllDeniedReimbursmentsForUser(User u);

	ReimbursementType getReimbursementType(String ersType);
	
	ReimbursementType retrieveType(int reimb_id1);
	
	
}
