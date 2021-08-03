package com.example.dao;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.models.User;
import com.example.models.UserRole;
import com.example.utils.HibernateUtil;

public class UserDaoDB implements UserDao {
	
	public UserDaoDB() {}
	
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
	
	public void updateUser(User u) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.update(u);
		tx.commit();
	}
	
	public List<User>getAllUsers(){
		Session ses = HibernateUtil.getSession();
		List<User> userList = ses.createQuery("from User", User.class).list();
		return userList;
	}
	
	@Override
	public User getUserByUserName(String username) {
		Session ses = HibernateUtil.getSession();
		User user = ses.createQuery("from User where username=:username", User.class).setString("username", username).uniqueResult();
		return user;
	}

	@Override
	public void deleteUser(User u) throws SQLException {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.delete(u);
		tx.commit();
		
	}

}
