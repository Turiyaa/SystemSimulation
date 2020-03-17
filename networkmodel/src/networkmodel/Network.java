package networkmodel;

import java.util.List;
import java.util.ArrayList;

public class Network implements Model {

	String name;
	int output;

	List<Model> models = new ArrayList<Model>();

	public Network(String n) {
		this.name = n;
	}

	public void addModel(Model model) {
		models.add(model);
	}

	@Override
	public void debug() {

	}

	@Override
	public String getName() {
		return name;
	}

	public void coupling(Model m, Pipe p, int mPipe) {
		int output;
		if (m.getName().equals("XOR1")) {
			output = p.inputValues[0] ^ p.inputValues[1];
			p.output(output);
		} else if (m.getName().equals("XOR2")) {
			output = p.storedVal ^ mPipe;
			p.output(output);
			this.output = output;
		} else if (m.getName().equals("Memory")) {
			p.output(p.storedVal);
		}
	}

	@Override
	public void lambda() {
		System.out.println("Network Output \t\t:" + output);

		for (Model m : models) {
			m.lambda();
		}
	}

	@Override
	public void delta(int input) {
		this.output = input;
	}

}
