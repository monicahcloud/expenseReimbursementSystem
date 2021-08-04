package com.example.services;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.example.dao.ReimbursementDao;
import com.example.dao.UserDao;
import com.example.exceptions.UserNameNotAvailable;
import com.example.logging.Logging;
import com.example.models.Reimbursement;
import com.example.models.ReimbursementType;
import com.example.models.User;

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


public Reimbursement submitReimb(int reimbAmount, User reimb_author, ReimbursementType type, String reimbDescription) {
	
	Reimbursement r = new Reimbursement(reimbAmount, reimb_author, type, reimbDescription);
	rDao.submitReimb(r);
	Logging.logger.info("New remibursement has been submitted.,");
	List<Reimbursement> rList = reimb_author.getReimbList();
	rList.add(r);
	return r;
}


//public Post addPost(User u, String content) {
//	Post p = new Post(0, u, content);
//	pDao.createPost(p);
//	List<Post> pList = u.getPosts();
//	pList.add(p);
//	uDao.updateUser(u);
//	return p;
//}
}
