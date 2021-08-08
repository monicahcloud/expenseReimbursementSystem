package com.example.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.example.dao.ReimbursementDao;
import com.example.dao.UserDao;
import com.example.dao.ReimbursementDao;
import com.example.exceptions.UserNameNotAvailable;
import com.example.logging.Logging;
import com.example.models.Reimbursement;
import com.example.models.ReimbursementType;
import com.example.models.User;
import com.example.utils.HibernateUtil;

public class ReimbursementServices {
	
	private ReimbursementDao rDao;
	private UserDao uDao;
	
public ReimbursementServices (ReimbursementDao r, UserDao d) {
	this.rDao = r;
	this.uDao = d;
}

public List<Reimbursement> getAllRemib(){
	return rDao.selectAllReimb();
	}

	      	 
public ReimbursementType getReimbursementType(String ersType) {
	return rDao.getReimbursementType(ersType);
}
	      	 

public Reimbursement addReimbursement(  int reimbAmount,  String reimbDescription ,ReimbursementType type ,User reimb_author) {
	Reimbursement r = new Reimbursement( reimbAmount, reimbDescription, type, reimb_author);
	rDao.addReimb(r);
	List<Reimbursement> rList = reimb_author.getReimList();
	rList.add(r);
	uDao.updateUser(reimb_author);
	return r;
}

public List<Reimbursement> getAllReimbursementsForUser(User u){
	List<Reimbursement> superList = new ArrayList<Reimbursement>();
	List<Reimbursement> a = rDao.getAllAcceptedReimbursmentsForUser(u);
	for(Reimbursement re:a) {
		superList.add(re);
	}
	List<Reimbursement> p = rDao.getAllPendingReimbursmentsForUser(u);
	for(Reimbursement r:p) {
		superList.add(r);
	}
	List<Reimbursement> d = rDao.getAllDeniedReimbursmentsForUser(u);
	for(Reimbursement rd:d) {
		superList.add(rd);
	}
	return superList;
}

public Reimbursement addReimbursement(int amount, String description,  User a) {
	Reimbursement r = new Reimbursement( amount, description, a);
	rDao.addReimb(r);
	List<Reimbursement> rList = a.getReimList();
	rList.add(r);
	uDao.updateUser(a);
	return r;
	
}

}