package vm;

public class State {
	private int quarter;
	private int nickel;
	private int dime;
	private int value;
	
	public int getQuarter() {
		return quarter;
	}

	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}

	public int getNickel() {
		return nickel;
	}

	public void setNickel(int nickel) {
		this.nickel = nickel;
	}

	public int getDime() {
		return dime;
	}

	public void setDime(int dime) {
		this.dime = dime;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	public String toString() {
		String str;
		str = "{"+quarter+", "+dime+", "+nickel+", "+value+"}\n";
		return str;
	}
}