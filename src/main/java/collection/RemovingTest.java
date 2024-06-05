package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RemovingTest {
	public static void main(String[] args) {
		List<User> users = new ArrayList<User>(Arrays.asList(new User[] {
			    new User("user1", 19),
			    new User("user2", 19),
			    new User("user3", 20),
			    new User("user4", 18),
			    new User("user5", 20)
			}));

        // 나이가 20 미만인 User 객체 제거
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getAge() < 20) {
                iterator.remove();
            }
        }
		
		for(User user : users) {
			System.out.println("user name : " + user.getName() + " user age : " + user.getAge());
		}
	}

}