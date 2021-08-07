import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.dao.UserDaoDB;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UserDoesNotExistException;
import com.example.models.User;
import com.example.models.UserRole;
import com.example.services.UserServices;


public class UserServiceTest {

	@InjectMocks
	public UserServices uServ;

	
	@Mock
	public UserDaoDB uDao;
	
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void testValidLogin() {
		UserRole r1 = new UserRole(1, "EMPLOYEE");
		UserRole r2 = new UserRole(2, "MANAGER");
		User u1 = new User (1, "test", "user",  "test@email.com", "testpass", r1);
		User not = new User(0, "test", "user",  "test@mail.com", "testpass", r2);
		
		when(uDao.getUserByUserName(any())).thenReturn(u1);
		
		User loggedIn = uServ.login("usertest", "testpass");
		
		assertEquals(u1.getUsername(), loggedIn.getUsername());
	}
	
	
	
	
}