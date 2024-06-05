package runningmachine;

import inherit.*;

public class RunningMachineV2 {

	public static void main(String[] args) {
		RunningMachineV2 machine = new RunningMachineV2();
		Animal human = new Human();
		machine.setRunner(human);
		machine.setSpeed(10);
		machine.play();
		
		Animal dog = new Dog();
		machine.setRunner(dog);
		machine.setSpeed(10);
		machine.play();
	}

	// 속도
	private int speed;
	
	// 운동하는 동물
	private Animal runner;
	
	public void play() {
		runner.run();
	}
	
	public void stop() {
		System.out.println("machine stop");
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Animal getRunner() {
		return runner;
	}

	public void setRunner(Animal runner) {
		this.runner = runner;
	}
}
