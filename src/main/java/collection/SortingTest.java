package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingTest {
	public static void main(String[] args) {
		List<User> users = new ArrayList<User>(Arrays.asList(new User[] {
			    new User("user1", 19),
			    new User("user2", 19),
			    new User("user3", 20),
			    new User("user4", 18),
			    new User("user5", 20)
			}));

		Collections.sort(users);
		for(User user : users) {			
			System.out.println("user name : " + user.getName() + " user age : " + user.getAge());
		}
		
	}

}
