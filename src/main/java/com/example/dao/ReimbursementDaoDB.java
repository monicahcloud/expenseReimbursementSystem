package com.example.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.models.Reimbursement;
import com.example.models.ReimbursementStatus;
import com.example.models.ReimbursementType;
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

	
	public Reimbursement updateReimb(Reimbursement r) {
	
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.update(r);
		tx.commit();
		return ses.get(Reimbursement.class, r.getReimb_id());
	}

	
	public Reimbursement selectReimbById(int reimb_id) {
		
		Session ses = HibernateUtil.getSession();
		Query q = ses.createQuery("from Reimbursement where id=:reimb_id");
		q.setInteger("id", reimb_id);
		Reimbursement reimb = (Reimbursement) q.uniqueResult();
		return reimb;
	}

	
	public List<Reimbursement> selectAllReimb(){
		
		Session ses = HibernateUtil.getSession();
		List<Reimbursement> rList = ses.createQuery("from Reimbursement ", Reimbursement.class).list();
		return rList;
	}

	

	public User getUserByUsername(String username) {
		Session ses = HibernateUtil.getSession();
		List<User> uList = ses.createQuery("from User where username='"+username+"'", User.class).list();
		if(uList.size() == 0) {
			return null;
		}
		return uList.get(0);
	}

	public User getAuthor(int author) {
		Session ses = HibernateUtil.getSession();
		User r = ses.createQuery("FROM Reimbursement WHERE reimb_author=" + author, User.class).uniqueResult();
		return r;
	}
	
	
	public List<Reimbursement> selectPending(){
		Session ses = HibernateUtil.getSession();
		String sql = "SELECT * FROM Reimbursement WHERE  status=:reimb_status_fk";
		SQLQuery query = HibernateUtil.getSession().createSQLQuery(sql);
		query.addEntity(Reimbursement.class);
		query.setParameter("reimb_status", new ReimbursementStatus(1, "PENDING"));
		return query.list();
	}
	
	
	public List<Reimbursement> selectResolved(){
		Session ses = HibernateUtil.getSession();
		String sql = "SELECT * FROM Reimbursement WHERE reimb_status NOT =:reimb_status";
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

	
	public ReimbursementType retrieveType(String rType) {
		Session ses = HibernateUtil.getSession();
		ReimbursementType rt = ses.get(ReimbursementType.class, rType);
		ses.update(rt);
		return rt;
	}
	
//	@Override
//	public ReimbursementStatus retrieveStatus() {
//		Session ses = HibernateUtil.getSession();
//		ReimbursementStatus rs = ses.get(ReimbursementStatus.class);
//		ses.update(rs);
//		return null;
//	}

	@Override
	public List<Reimbursement> getAllPendingReimbursmentsForUser(User u) {
		Session ses = HibernateUtil.getSession();
		List<Reimbursement> rList = ses.createQuery("from Reimbursement where id = 1", Reimbursement.class).list();
		List<Reimbursement> result = new ArrayList<Reimbursement>();
		for(Reimbursement curr:rList) {
			if(curr.getReimb_author()==u) {
				result.add(curr);
			}
		}
		return result;
	}

	@Override
	public List<Reimbursement> getAllAcceptedReimbursmentsForUser(User u) {
		Session ses = HibernateUtil.getSession();
		List<Reimbursement> rList = ses.createQuery("from Reimbursement where id = 2", Reimbursement.class).list();
		List<Reimbursement> result = new ArrayList<Reimbursement>();
		for(Reimbursement curr:rList) {
			if(curr.getReimb_author()==u) {
				result.add(curr);
			}
		}
		return result;
	}
	@Override
	public List<Reimbursement> getAllDeniedReimbursmentsForUser(User u) {
		Session ses = HibernateUtil.getSession();
		List<Reimbursement> rList = ses.createQuery("from Reimbursement where id = 3", Reimbursement.class).list();
		List<Reimbursement> result = new ArrayList<Reimbursement>();
		for(Reimbursement curr:rList) {
			if(curr.getReimb_author()==u) {
				result.add(curr);
			}
		}
		return result;
	}

	public ReimbursementType retrieveType(int reimb_id1) {
		String sql = "SELECT * FROM reimb_type WHERE type_id: reimb_id ";
		SQLQuery query = HibernateUtil.getSession().createSQLQuery(sql);
		query.addEntity(ReimbursementType.class);
		query.setParameter("reimb_id", reimb_id1);
		List results = query.list();
		return (ReimbursementType)results.get(0);
		
	}

	@Override

	public ReimbursementType getReimbursementType(String ersType) {
		Session ses = HibernateUtil.getSession();
		ReimbursementType r = ses.createQuery("from ReimbursementType where type=" + ersType, ReimbursementType.class).uniqueResult();
		return r;
	}
	
	
		
}