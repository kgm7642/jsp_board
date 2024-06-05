package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GatheringTest {

	public static void main(String[] args) {
		List<User> users = new ArrayList<User>(Arrays.asList(new User[] {
			    new User("user1", 19),
			    new User("user2", 19),
			    new User("user3", 20),
			    new User("user4", 18),
			    new User("user5", 20)
			}));
		
		Map<Integer, List<User>> ageUsersMap = new HashMap<Integer, List<User>>();
		for (User user : users) {
			List<User> userList = new ArrayList<User>();
			userList.add(user);
			// Map에 나이가 처음 저장될 때
			if(ageUsersMap.get(user.getAge()) == null) {
				ageUsersMap.put(user.getAge(), userList);
			} else {
				// 이미 Map에 같은 나이가 저장되어 있을 때
				ageUsersMap.get(user.getAge()).add(user);
			}
		}
		
		for(Entry<Integer, List<User>> entrySet : ageUsersMap.entrySet()) {
			System.out.println(entrySet.getKey() + " : " + entrySet.getValue().size() + "명");
		}
	}
}
