package board;

import java.sql.Timestamp;

public class User {
	
	// 테이블 아이디
	private long id;
	// 유저 아이디
	private String name;
	// 유저 이름
	private String fullName;
	// 비밀번호
	private String password;
	// 이메일
	private String email;
	// 나이
	private int age;
	// 회원가입시간
	private Timestamp createDate;	
		
	public User() {
		super();
	}
	
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	public User(String fullName, String password, String email, int age) {
		this.fullName = fullName;
		this.password = password;
		this.email = email;
		this.age = age;
	}

	public User(String name, String fullName, String password, String email, int age) {
		super();
		this.name = name;
		this.fullName = fullName;
		this.password = password;
		this.email = email;
		this.age = age;
	}
	
	public User(long id, String name, String fullName, String password, String email, int age, Timestamp createDate) {
		super();
		this.id = id;
		this.name = name;
		this.fullName = fullName;
		this.password = password;
		this.email = email;
		this.age = age;
		this.createDate = createDate;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
}
