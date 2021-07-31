package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.models.Reimbursement;
import com.example.models.User;
import com.example.utils.HibernateUtil;

public class ReimbursementDaoDB implements ReimbursementDao{
	
	public ReimbursementDaoDB() {}
	
	//Transaction is only needed if you are adding data to the database..
	public void addReimb(Reimbursement r) {
		
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(r);
		tx.commit();
	}

	public void updateReimb(Reimbursement r) {
	
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.update(r);
		tx.commit();
	}

	public Reimbursement selectReimbById(int id) {
		
		Session ses = HibernateUtil.getSession();
		Reimbursement reimb = ses.get(Reimbursement.class, id);
		return reimb;
	}

	public List<Reimbursement> selectAllReimb(){
		
		Session ses = HibernateUtil.getSession();
		List<Reimbursement> reimbList = ses.createQuery("from Reimbursement", Reimbursement.class).list();
		return reimbList;
	}

	
	@Override
	public List<Reimbursement> getAllReimbursement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement getReimbursementByUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteReimb(Reimbursement r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Reimbursement> getUserReimbursement(Reimbursement r) {
		// TODO Auto-generated method stub
		return null;
	}
}
