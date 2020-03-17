import java.util.ArrayList;
import java.util.List;

public class Model extends State {

	public void delta(String input) throws VendingMachineException {
		
		while (getValue() >= VMConstant.DOLLAR) {
			setValue(getValue() - VMConstant.DOLLAR);
		}

		if (isChange()) {
			ArrayList<String> change = change(getValue());

			for (String coin : change) {
				if (coin.equals("q")) {
					setValue(getValue() - VMConstant.QUARTER);
				} else if (coin.equals("d")) {
					setValue(getValue() - VMConstant.DIME);

				} else if (coin.equals("n")) {
					setValue(getValue() - VMConstant.NICKEL);

				}
			}
		}

		boolean cancel = false;
		for (int i = 0; i < input.length(); i++) {
			char inputValue = input.charAt(i);
			switch (inputValue) {
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
			case 'c':
				cancel = true;
				break;
			}
		}

		setChange(cancel);
	}

	public void lambda() throws VendingMachineException {
		List<String> lambdaOutput = new ArrayList<String>();
		int remainingCoin = getValue();

		while (remainingCoin >= VMConstant.DOLLAR) {
			remainingCoin = remainingCoin - VMConstant.DOLLAR;
			lambdaOutput.add("coffee");
		}

		if (isChange()) {
			lambdaOutput.addAll(change(remainingCoin));
		}

		if (lambdaOutput.isEmpty()) {
			lambdaOutput.add("nothing");
		}
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
}