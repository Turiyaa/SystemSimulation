package networkmodel;

public class Pipe {
	int storedVal;
	int[] inputValues;
	int memoryPipe;

	public int output(int val) {
		this.storedVal = val;
		return storedVal;
	}

	public int[] input() {
		return inputValues;
	}

	public int memoryPipe() {
		return memoryPipe;
	}
}
