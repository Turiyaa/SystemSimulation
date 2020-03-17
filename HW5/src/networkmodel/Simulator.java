package networkmodel;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

import networkmodel.Event.EventType;

public class Simulator {
	Network network;

	public Simulator(Network n) {
		this.network = n;
	}

	public void simulate(BufferedReader br) throws IOException {
		String line;

		network.lambda();

		while ((line = br.readLine()) != null) {
			double time;
			int parts;
			Scanner scan = new Scanner(System.in);
			String[] strs = line.trim().split("\\s+");
			time = Double.parseDouble(strs[0]);
			parts = Integer.parseInt(strs[1]);
			Event e;
			for (int i = 0; i < parts; i++) {
				e = new Event(time, network, EventType.EXT);
				network.getPq().add(e);
			}

		}
		network.setGlobalTime(network.pq.peek().getTime());

		while (!network.getPq().isEmpty()) {
			network.lambda();
			Event e = network.getPq().poll();

			if (e.getTime() > network.getGlobalTime())
				network.setGlobalTime(e.getTime());

			network.coupling(network.getGlobalTime(), e.getModel(), e);
		}
		network.lambda();
	}
}
