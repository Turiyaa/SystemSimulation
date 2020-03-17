package networkmodel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		Network network = new Network("Network");
		XOR XOR1 = new XOR("XOR1");
		XOR XOR2 = new XOR("XOR2");
		Memory M = new Memory("Memory");

		network.addModel(XOR1);
		network.addModel(XOR2);
		network.addModel(M);

		
		boolean debugMode = false;
		boolean processFile = false;
		BufferedReader br = null;
		Scanner scan = new Scanner(System.in);
		System.out.print("Process batch file? (yes/no):");

		String batchFile;
		batchFile = scan.next();
		if (batchFile.toLowerCase().equals("yes")) {
			processFile = true;
			System.out.print("Enter file name\t\t: ");
			batchFile = scan.next();
			FileReader fr = new FileReader(batchFile);
			br = new BufferedReader(fr);
		}
		String debug;
		System.out.print("Debug Mode? (yes/no)\t:");
		debug = scan.next();
		if (debug.toLowerCase().equals("yes")) {
			debugMode = true;
		}
		
		Simulator sim = new Simulator(network, M);
		sim.simulate(debugMode, processFile, br);
	}
}
