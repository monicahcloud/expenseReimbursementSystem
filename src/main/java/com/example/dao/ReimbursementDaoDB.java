package com.example.dao;

import java.sql.SQLException;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.models.Reimbursement;
import com.example.models.ReimbursementStatus;
import com.example.models.User;
import com.example.utils.HibernateUtil;

public class ReimbursementDaoDB implements ReimbursementDao{
	
	public ReimbursementDaoDB() {}
	
	//Transaction is only needed if you are adding data to the database..
	public void submitReimb(Reimbursement r) {
		
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
//		return ses.get(Reimbursement.class, r.getReimb_id());
	}

	
	public Reimbursement selectReimbById(int reimb_id) {
		
		Session ses = HibernateUtil.getSession();
		Reimbursement reimb = ses.get(Reimbursement.class, reimb_id);
		return reimb;
	}

	
	public List<Reimbursement> selectAllReimb(){
		
		Session ses = HibernateUtil.getSession();
		List<Reimbursement> rList = ses.createQuery("from reimbursement ORDER BY reimbID", Reimbursement.class).list();
		for (Reimbursement reimb: rList) {
			Reimbursement r = new Reimbursement( reimb.getReimbAmount(), reimb.getReimbSubmitted(), reimb.getReimbResolved(), reimb.getReimbDescription(), reimb.getStatus(), reimb.getType(), reimb.getReimb_author(),reimb.getReimb_resolver());
		}
		return rList;
	}

	
	public List<Reimbursement> selectPending(){
		Session ses = HibernateUtil.getSession();
		String sql = "SELECT * FROM reimburesment WHERE reimb_status_fk =:_status";
		SQLQuery query = HibernateUtil.getSession().createSQLQuery(sql);
		query.addEntity(Reimbursement.class);
		query.setParameter("reimb_status", new ReimbursementStatus(1, "PENDING"));
		return query.list();
	}
	
	
	public List<Reimbursement> selectResolved(){
		Session ses = HibernateUtil.getSession();
		String sql = "SELECT * FROM reimburesment WHERE reimb_status NOT =:reimb_status";
		SQLQuery query = HibernateUtil.getSession().createSQLQuery(sql);
		query.addEntity(Reimbursement.class);
		query.setParameter("reimb_status", new ReimbursementStatus(1, "PENDING"));
		return query.list();
	}
	
	
	@Override
	public void deleteReimb(Reimbursement r) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.delete(r);
		tx.commit();
	}

	
	
	@Override
	public Reimbursement getReimbursementByStatus() {
		// TODO Auto-generated method stub
		return null;
	}



	
}
