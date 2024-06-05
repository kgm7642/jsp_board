package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MariaUserService extends ServiceManager implements UserService {
	
	// ID, PW를 통해 DB에 값이 있는지 확인후 존재하면 User 리턴 
	public User getUser(User user) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
//			stmt = conn.prepareStatement("select * from user where name = '" + user.getName() + "' and password = '" + user.getPassword() + "'");
			stmt = conn.prepareStatement("select * from user where name = ? and password = ?");
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getPassword());
			
			ResultSet rs = stmt.executeQuery();
			
			
			// 로그인 성공
			if(rs.next()){
				System.out.println("로그인 성공 확인");
				user.setId(rs.getLong("id"));
				user.setName(rs.getString("name"));
				user.setFullName(rs.getString("fullName"));
				user.setEmail(rs.getString("email"));
				user.setAge(rs.getInt("age"));
				
				return user;
			// 로그인 실패
			} else {
				System.out.println("로그인 실패 확인");
				return null;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
