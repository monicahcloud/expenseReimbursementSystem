//import java.util.Scanner;
//
//import com.example.dao.UserDao;
import java.util.ArrayList;
import java.util.List;

import com.example.dao.ReimbursementDaoDB;
import com.example.dao.UserDaoDB;
import com.example.models.Reimbursement;
import com.example.models.ReimbursementStatus;
import com.example.models.ReimbursementType;
import com.example.models.User;
import com.example.models.UserRole;
import com.example.utils.HibernateUtil;

public class Driver {
	
	public static void main(String[] args) {
		
		
		UserDaoDB uDao = new UserDaoDB();
		ReimbursementDaoDB rDao = new ReimbursementDaoDB();

		ReimbursementType reimbType1 = new ReimbursementType(1, "FOOD");
		ReimbursementType reimbType2 = new ReimbursementType(2, "TRAVEL");
		ReimbursementType reimbType3 = new ReimbursementType(3, "LODGING");
		ReimbursementType reimbType4 = new ReimbursementType(4, "OTHER");
		
		ReimbursementStatus reimbStatus1 = new ReimbursementStatus(1, "PENDING");
		ReimbursementStatus reimbStatus2 = new ReimbursementStatus(2, "APPROVED");
		ReimbursementStatus reimbStatus3 = new ReimbursementStatus(3, "DENIED");
	
		UserRole uR1 = new UserRole(1, "EMPLOYEE");
		UserRole uR2 = new UserRole(2, "MANAGER");
		
		User u = new User("Jane", "Doe", "password", "jane@gmail.com", uR2);
		User u1 = new User("Joe", "Doe", "password", "john@gmail.com", uR1);
		User u2 = new User("Jennifer", "Hudson", "password", "givingmyself@gmail.com", uR2);
		
		uDao.addUser(u2);
		uDao.addUser(u);
		uDao.addUser(u1);

		Reimbursement r1 = new Reimbursement (50, "dinner with client at Intermezzio Cafe", reimbStatus2, reimbType1, u , u1);
		rDao.addReimb(r1);
		Reimbursement r2 = new Reimbursement (150, "3 night business trip in San Diego, CA", reimbStatus1, reimbType3, u2, u);
		rDao.addReimb(r2);
//		Reimbursement r3 = new Reimbursement (250, "Business Trip: Airplane and Car rental",  reimbStatus3, reimbType4);
//		rDao.addReimb(r3);
//		Reimbursement r4 = new Reimbursement (150, "personal mini vacation at companies expense",  reimbStatus2, reimbType2);
//		rDao.addReimb(r4);
		
		List<Reimbursement> rList = new ArrayList<Reimbursement>();
		rList.add(r1);
		rList.add(r2);
//		rList.add(r3);
//		rList.add(r4);
	
		}

}
