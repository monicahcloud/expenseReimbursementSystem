
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
import com.example.services.ReimbursementServices;
import com.example.services.UserServices;
import com.example.utils.HibernateUtil;

public class Driver {
	
	public static void main(String[] args) {
		
		
		UserDaoDB uDao = new UserDaoDB();
		UserServices uServ = new UserServices(uDao);
		
				
		ReimbursementDaoDB rDao = new ReimbursementDaoDB();
		ReimbursementServices rServ = new ReimbursementServices(rDao, uDao);
		
		ReimbursementStatus reimbStatus1 = new ReimbursementStatus(1, "PENDING");
		ReimbursementStatus reimbStatus2 = new ReimbursementStatus(2, "APPROVED");
		ReimbursementStatus reimbStatus3 = new ReimbursementStatus(3, "DENIED");
	
		UserRole uR1 = new UserRole(1, "EMPLOYEE");
		UserRole uR2 = new UserRole(2, "MANAGER");
		
		ReimbursementType reimbType1 = new ReimbursementType(1, "FOOD");
		ReimbursementType reimbType2 = new ReimbursementType(2, "TRAVEL");
		ReimbursementType reimbType3 = new ReimbursementType(3, "LODGING");
		ReimbursementType reimbType4 = new ReimbursementType(4, "OTHER");
		
		User u = new User("Bugs", "Bunny",  "bugs@gmail.com","password", uR2);
		User u1 = new User("Roger", "Rabbit", "roger@gmail.com","password",  uR1);
		User u2 = new User("Easter", "Buny", "egghunt@gmail.com","password",  uR2);
		User u3 = new User("Elmer", "Fudge", "moody@gmail.com","password",  uR2);
		User u4 = new User("Daffy", "Duck", "goofyr@gmail.com", "password",  uR1);
		User u5 = new User("Mickey", "Mouse", "rodent@gmail.com","password",  uR1);
		User u6= new User("Minnie", "Mouse", "lover@gmail.com","password",  uR1);
		User u7 = new User("Taz", "Devil", "psycho@gmail.com","password",  uR1);
		User u8 = new User("Miss", "Piggy", "bosslady@gmail.com","password",  uR2);
		
		
//		User u3 = uServ.login("MickeyMouse1483", "password");
//		System.out.println(u3);
//		
		//submit reimbursement
//		Reimbursement r = rServ.submitReimb(0,"business trip to Japan", reimbType4, u);
//		Reimbursement r1 = rServ.submitReimb(0, "trip to Europe", reimbType4, u);
	
		uDao.addUser(u2);
		uDao.addUser(u);
		uDao.addUser(u3);

		uDao.addUser(u4);
		uDao.addUser(u5);
		uDao.addUser(u6);

		uDao.addUser(u7);
		uDao.addUser(u8);
		uDao.addUser(u1);

		Reimbursement r1 = new Reimbursement (150, "3 night business trip in San Diego, CA", reimbStatus1, reimbType3, u2, u);
		rDao.addReimb(r1);
		Reimbursement r2 = new Reimbursement (250, "Business Trip: Airplane and Car rental", reimbStatus2, reimbType3, u3, u2);
		rDao.addReimb(r2);
		Reimbursement r3 = new Reimbursement (150, "personal mini vacation at companies expense", reimbStatus2, reimbType2, u3, u8);
		rDao.addReimb(r3);
		
		Reimbursement r5 = new Reimbursement (410, "3 night business trip in San Diego, CA",reimbStatus1, reimbType4, u4, u6);
		rDao.addReimb(r5);
		Reimbursement r6 = new Reimbursement (250, "Business Trip: Airplane and Car rental", reimbStatus1,reimbType3, u5, u);
		rDao.addReimb(r6);
		Reimbursement r7 = new Reimbursement (150, "personal mini vacation at companies expense", reimbStatus3, reimbType1, u3,u6);
		rDao.addReimb(r7);
		Reimbursement r8 = new Reimbursement (150, "3 night business trip in San Diego, CA",reimbStatus1, reimbType3, u1, u);
		rDao.addReimb(r8);
		Reimbursement r9 = new Reimbursement (250, "Business Trip: Airplane and Car rental", reimbStatus1, reimbType1,u7, u2);
		rDao.addReimb(r9);
		Reimbursement r10 = new Reimbursement (150, "personal mini vacation at companies expense",reimbStatus1, reimbType2, u3, u2);
		rDao.addReimb(r10);
		
		Reimbursement r11 = new Reimbursement (150, "3 night business trip in San Diego, CA",reimbStatus2, reimbType4, u4, u);
		rDao.addReimb(r11);
		Reimbursement r12 = new Reimbursement (250, "Business Trip: Airplane and Car rental",reimbStatus3, reimbType3, u5, u6);
		rDao.addReimb(r12);
		Reimbursement r13 = new Reimbursement (150, "personal mini vacation at companies expense", reimbStatus1,reimbType1, u6, u8);
		rDao.addReimb(r13);
		
		List<Reimbursement> rList = new ArrayList<Reimbursement>();
		rList.add(r1);
		rList.add(r2);
		rList.add(r3);
		rList.add(r5);
		rList.add(r6);
		rList.add(r7);
	
		}

}
