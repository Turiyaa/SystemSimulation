package networkmodel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		Network network = new Network("Network");
		Machine press = new Machine("Press", 1.0);
		Machine drill = new Machine("Drill", 2.0);
		
		network.addModel(press);
		network.addModel(drill);

		BufferedReader br = null;

		String batchFile = "input";
		FileReader fr = new FileReader(batchFile);
		br = new BufferedReader(fr);

		Simulator sim = new Simulator(network);
		sim.simulate(br);
	}
}
