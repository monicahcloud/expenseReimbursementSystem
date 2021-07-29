package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.models.Reimbursement;

import com.example.utils.HibernateUtil;

public class ReimbursementDaoDB {
	
	public ReimbursementDaoDB() {}
	
	//Transaction is only needed if you are adding data to the database..
	public void addReimbursement(Reimbursement r) {
		
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(r);
		tx.commit();
	}

	public void update(Reimbursement r) {
	
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.update(r);
		tx.commit();
	}

	public Reimbursement selectById(int id) {
		
		Session ses = HibernateUtil.getSession();
		Reimbursement reimb = ses.get(Reimbursement.class, id);
		return reimb;
	}

	public List<Reimbursement> selectAllReimb(){
		
		Session ses = HibernateUtil.getSession();
		List<Reimbursement> reimbList = ses.createQuery("from Reimbursement", Reimbursement.class).list();
		return reimbList;
	}
}
