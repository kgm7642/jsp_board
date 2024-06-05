package person;

public class Person {
	public static void main(String[] args) {
		Person hong = new Person("홍길동", "남자", 18);
		if(args[0].equals("walk")) {
			hong.walk();
		} else {
			hong.say(args[0]);
		}
	}
	
	private String name;
	private String gender;
	private int age;
	
	Person(String name, String gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	
	public void walk() {
		System.out.println("walk");
	}
	
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
