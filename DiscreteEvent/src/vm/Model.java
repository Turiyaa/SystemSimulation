package vm;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Model extends State {

	public Model() {
		super();
	}

	public void deltaint() throws VendingMachineException {
		lambda();
		while (getValue() >= VMConstant.DOLLAR) {
			setValue(getValue() - VMConstant.DOLLAR);
		}

		ArrayList<String> change = change(getValue());

		for (String coin : change) {
			if (coin.equals("q")) {
				setQuarter(getQuarter() - 1);
				setValue(getValue() - VMConstant.QUARTER);
			} else if (coin.equals("d")) {
				setDime(getDime() - 1);
				setValue(getValue() - VMConstant.DIME);
			} else if (coin.equals("n")) {
				setDime(getNickel() - 1);
				setValue(getValue() - VMConstant.NICKEL);

			}
		}

	}

	public void deltaext(char input) throws VendingMachineException {
		switch (input) {
		case 'q':
			setQuarter(getQuarter() + 1);
			setValue(getValue() + VMConstant.QUARTER);
			break;
		case 'd':
			setDime(getDime() + 1);
			setValue(getValue() + VMConstant.DIME);
			break;
		case 'n':
			setNickel(getNickel() + 1);
			setValue(getValue() + VMConstant.NICKEL);
			break;
		}
	}

	public void deltacon(char input) throws VendingMachineException {
		deltaint();
		deltaext(input);
	}

	public void lambda() throws VendingMachineException {
		List<String> lambdaOutput = new ArrayList<String>();
		int remainingCoin = getValue();

		while (remainingCoin >= VMConstant.DOLLAR) {
			remainingCoin = remainingCoin - VMConstant.DOLLAR;
			lambdaOutput.add("coffee");
		}

		lambdaOutput.addAll(change(remainingCoin));

		System.out.println(lambdaOutput);

	}

	public ArrayList<String> change(int remainingCoin) throws VendingMachineException {
		ArrayList<String> change = new ArrayList<String>();
		while (true)
			if (remainingCoin != 0) {
				if (getQuarter() > 0 && remainingCoin >= VMConstant.QUARTER) {
					remainingCoin -= VMConstant.QUARTER;
					change.add("q");
				} else if (getDime() > 0 && remainingCoin >= VMConstant.DIME) {
					remainingCoin -= VMConstant.DIME;
					change.add("d");

				} else if (getNickel() > 0 && remainingCoin >= VMConstant.NICKEL) {
					remainingCoin -= VMConstant.NICKEL;
					change.add("n");
				} else {
					throw new VendingMachineException("Insuffficient coins, call manager!");
				}
			} else {
				break;
			}
		return change;
	}

	public double timeAdvance() {

		return getValue() > 0 ? format(2.0) : Double.POSITIVE_INFINITY;
	}

	public double format(double time) {
		DecimalFormat df = new DecimalFormat("###0.0");
		String val = df.format(time);
		time = Double.valueOf(val);
		return time;
	}
}