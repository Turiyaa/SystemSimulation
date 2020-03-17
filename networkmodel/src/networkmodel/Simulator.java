package networkmodel;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class Simulator {
	Network network;
	Memory memory;

	public Simulator(Network n, Memory m) {
		this.network = n;
		this.memory = m;
	}

	public void simulate(boolean debugMode, boolean processFile, BufferedReader br) throws IOException {

		while (true) {

			int b1;
			int b2;
			Scanner scan = new Scanner(System.in);

			if (!processFile) {
				System.out.print("Input 1:");
				b1 = scan.nextInt();
				System.out.print("Input 2:");
				b2 = scan.nextInt();
			} else {
				String line;
				if ((line = br.readLine()) != null) {
					b1 = Character.getNumericValue(line.charAt(0));
					b2 = Character.getNumericValue(line.charAt(1));
				} else {
					break;
				}

			}

			Pipe p = new Pipe();
			int input[] = { b1, b2 };
			p.inputValues = input;

			if (processFile)
				System.out.println("Input \t\t\t:" + "{" + b1 + " " + b2 + "}");
			network.lambda();

			simulateModels(p);

			if (debugMode) {
				for (Model m : network.models) {
					m.debug();
				}
			}
			System.out.println();
		}
	}

	private void simulateModels(Pipe p) {

		for (int i = 0; i < 3; i++) {
			int pipe = memory.getCurrentState();
			for (int j = 0; j < network.models.size(); j++) {
				network.coupling(network.models.get(j), p, pipe);

				network.models.get(i).delta(p.storedVal);
			}
		}
	}
}
