package board;

public interface UserService {

	// 회원가입
	User join(User user);
	
	// 아이디 중복체크
	Boolean checkName(String name);
	
	// 로그인
	User getUser(User user);
	
	// 회원정보 수정
	User updateInfo(User user);
}
