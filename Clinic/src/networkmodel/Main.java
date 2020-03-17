package networkmodel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import atomic.Atomic;

public class Main {

	public static void main(String[] args) throws IOException {

		Network network = new Network("Clinic");
		Atomic checkIn = new Atomic("CheckIn", 2.0);
		Atomic NRS1 = new Atomic("NRS1", 15.0);
		Atomic NRS2 = new Atomic("NRS2", 15.0);
		Atomic examRoom = new Atomic("ExamRoom", 10.0);
		
		network.addModel(checkIn);
		network.addModel(NRS1);
		network.addModel(NRS2);
		network.addModel(examRoom);

		//checkIn input is Clinic(Network)
		//checkIn output goes to either NRS1 and NRS2
		//NRS1 and NRS2 output goes to examRoom
		//examRoom is the output

		BufferedReader br = null;

		String batchFile = "input";
		FileReader fr = new FileReader(batchFile);
		br = new BufferedReader(fr);

		Simulator sim = new Simulator(network);
		sim.simulate(br);
	}
}
