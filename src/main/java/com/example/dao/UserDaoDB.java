package com.example.dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.models.User;
import com.example.utils.HibernateUtil;

public class UserDaoDB {
	
	public UserDaoDB() {	
	}
	
	public void addUser(User u) {
		
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(u);
		tx.commit();
		}
	
	public User getUserByEmployeeNumber(int employee_number) {
		Session ses = HibernateUtil.getSession();
		User user = ses.get(User.class, employee_number );
		return user;
	}
	
	
	public User selectByUsername(String username) {
		Session ses = HibernateUtil.getSession();
		List<User> userList = ses.createNativeQuery("select * from ers_users where name = '" + username + "'", User.class).list();
	 return userList.get(0);
	}
	
	
	public void update(User u) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.update(u);
		tx.commit();
	}
	
	public List<User>selectAll(){
		Session ses = HibernateUtil.getSession();
		List<User> userList = ses.createQuery("from User", User.class).list();
		return userList;
	}
	
	//employee
	public User addRequest() {
		Session ses = HibernateUtil.getSession();
		
		return null;
	}
	
	//employee
	public User viewStatus() {
		Session ses = HibernateUtil.getSession();
		
		return null;
	}
	
	//manager
	public User ViewRequest() {
		Session ses = HibernateUtil.getSession();
		
		return null;
	}

}
