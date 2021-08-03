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
	public void testLogin() {
	UserRole r1 = new UserRole("EMPLOYEE");
	UserRole r2 = new UserRole("MANAGER");
		
		User u = new User(1, "User", "Test", "test@email.com", "testpassword", r1);
		User notUser = new User(0, "User", "Test", "test@email.com", "testpassword", r2);
		
		when(uDao.selectByUsername(anyString())).thenReturn(u);
		User logIn = uServ.login("User", "testpassword");
		
		assertEquals(u.getEmpNumber(), logIn.getEmpNumber());
	}
	
	
	
}