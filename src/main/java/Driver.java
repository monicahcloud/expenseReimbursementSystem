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
		
		ReimbursementType reimbType1 = new ReimbursementType("Food");
		ReimbursementType reimbType2 = new ReimbursementType("Travel");
		ReimbursementType reimbType3 = new ReimbursementType("Lodging");
		ReimbursementType reimbType4 = new ReimbursementType("Other");
		
		ReimbursementStatus reimbStatus1 = new ReimbursementStatus("Approved");
		ReimbursementStatus reimbStatus2 = new ReimbursementStatus("Pending");
		ReimbursementStatus reimbStatus3 = new ReimbursementStatus("Denied");
		
		UserRole uR1 = new UserRole("employee");
		UserRole uR2 = new UserRole("manager");
		
		
		Reimbursement r1 = new Reimbursement (50, "dinner with client at Intermezzio Cafe",reimbStatus1, reimbType1, uDao.getUserByEmployeeNumber(691));
		rDao.addReimbursement(r1);
		Reimbursement r2 = new Reimbursement (150, "3 night business trip in San Diego, CA");
		rDao.addReimbursement(r2);
		Reimbursement r3 = new Reimbursement (250, "Business Trip: Airpland and Car rental");
		rDao.addReimbursement(r3);
		Reimbursement r4 = new Reimbursement (150, "personal mini vacation at companies expense");
		rDao.addReimbursement(r4);
		
		List<Reimbursement> rList = new ArrayList<Reimbursement>();
		rList.add(r1);
		rList.add(r2);
		rList.add(r3);
		rList.add(r4);
				
		User u = new User("Chasworth", "Cloud", "password", "chasworthcloud@gmail.com", uR1, rList);
		User u1 = new User("Monicah", "Cloud", "password", "monicahcloud@gmail.com", uR2, rList);
		User u2 = new User("Ruth", "Cloud", "password", "ruthcloud@gmail.com", uR1, rList);
		uDao.addUser(u2);
		uDao.addUser(u);
		uDao.addUser(u1);
		
		System.out.println(uDao.selectAll());
	
		}

}
