package inherit;

public class Animal {

	// 체중
	private int weight;
	
	// 뛰다
	public void run() {
		System.out.println("run");
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
