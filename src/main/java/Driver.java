//import java.util.Scanner;
//
//import com.example.dao.UserDao;
import com.example.dao.UserDaoDB;
import com.example.models.User;
import com.example.utils.HibernateUtil;

public class Driver {
	
	
	
	public static void main(String[] args) {
		
		UserDaoDB uDao = new UserDaoDB();
		User u = new User("Monicah", "Cloud", "password", "monicahcloud@gmail.com", "employee");
		uDao.insert(u);
	HibernateUtil.closeSession();
		}

}
