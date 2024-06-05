package inherit;

import runningmachine.Runner;

public class Human extends Animal implements Runner{

	// 혈액형
	private String bloodType;
	
	// 뛰다
	public void run() {
		System.out.println("human run");
	}
	
	// 말하다
	public void say(String word) {
		System.err.println("say");
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	
	

}
