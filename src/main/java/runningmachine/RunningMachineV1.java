package runningmachine;

import inherit.Human;

public class RunningMachineV1 {
	public static void main(String[] args) {
		RunningMachineV1 machine = new RunningMachineV1();
		Human human = new Human();
		machine.setRunner(human);
		machine.setSpeed(10);
		machine.play();
	}
	
	// 속도
	private int speed;
	
	// 운동하는 사람
	private Human runner;
	
	
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

	public Human getRunner() {
		return runner;
	}

	public void setRunner(Human runner) {
		this.runner = runner;
	}
}
