package person;

// 사람
public class Person {
	public static void main(String[] args) {
		Person hong = new Person("홍길동", "남자", 18);
		if(args[0].equals("walk")) {
			hong.walk();
		} else {
			hong.say(args[0]);
		}
	}
	
	// 이름
	private String name;
	//성별
	private String gender;
	// 나이
	private int age;
	
	Person() {
		
	}
	
	Person(String name, String gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	
	// 걷다
	public void walk() {
		System.out.println("walk");
	}
	
	// 말하다
	public void say(String word) {
		System.out.println("say");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
