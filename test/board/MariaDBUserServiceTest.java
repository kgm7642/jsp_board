package board;

import static org.junit.Assert.*;

import org.junit.Test;

public class MariaDBUserServiceTest {

	UserService userService = new  MariaUserService();
	
	// 로그인 service 테스트
	@Test
	public void testGetUser() {
		User user = new User("user1", "1234");

		User loginUser = userService.getUser(user);
		System.out.println(">> loginUser=" + loginUser);
	}
}
