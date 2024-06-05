package runningmachine;

import inherit.*;

public class RunningMachineV3 {

	public static void main(String[] args) {
		RunningMachineV3 machine = new RunningMachineV3();
		
		Human human = new Human();
		machine.setRunner(human);
		machine.play();
		
		Dog dog = new Dog();
		machine.setRunner(dog);
		machine.play();
		
		Robot robot = new Robot();
		machine.setRunner(robot);
		machine.play();
		
	}

	// 뛰는 대상
	private Runner runner;
	
	// 속도
	private int speed;

	public void play() {
		this.runner.run();
	}
	
	public void stop() {
		System.out.println("machine stop");
	}

	public Runner getRunner() {
		return runner;
	}

	public void setRunner(Runner runner) {
		this.runner = runner;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}
