package networkmodel;

public class XOR implements Model {

	int s;
	String name;
	int previousState;

	public XOR(String n) {
		this.name = n;

	}

	@Override
	public void lambda() {
		System.out.println(name + " state \t\t:" + s);
		previousState = s;
	}

	@Override
	public void delta(int input) {
		s = input;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void debug() {
		if (previousState != s)
			System.out.println(name + " new state\t\t:" + s);
	}

}
