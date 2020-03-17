package networkmodel;

public class Memory implements Model {
	int q1, q2;
	String name;
	int prevSq1, prevSq2;

	public Memory(String n) {
		this.name = n;
	}

	@Override
	public void lambda() {
		System.out.println(name + " state\t\t:" + "{" + q1 + "," + q2 + "}");
		prevSq1 = q1;
		prevSq2 = q2;
	}

	@Override
	public void delta(int input) {
		q1 = q2;
		q2 = input;
	}

	@Override
	public String getName() {
		return name;
	}

	public int getCurrentState() {
		return q1;
	}

	@Override
	public void debug() {
		if (!(q1 == prevSq1 && q2 == prevSq2))
			System.out.println(name + " new state\t:" + "{" + q1 + "," + q2 + "}");
	}

}
