package networkmodel;

import java.util.ArrayList;
import java.util.List;

import networkmodel.Event.EventType;

public class Network implements Model {

	String name;
	int output;
	double globalTime;

	PQ<Event> pq = new PQ<Event>();

	List<Model> models = new ArrayList<Model>();

	public Network(String n) {
		this.name = n;
	}

	@Override
	public double ta() {
		return output;

	}

	public void addModel(Model model) {
		models.add(model);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void lambda() {
		if (output == 1) {
			System.out.println("Output: time = " + globalTime + " Washer\n");
		}
		for (int i = 0; i < models.size(); i++) {
			System.out.println("State: time = " + globalTime + ", " + models.get(i));
		}
		System.out.println("\n");
		output = 0;
	}

	@Override
	public void deltaint() {

	}

	@Override
	public void deltaext(double e, int input) {

	}

	@Override
	public void deltacon(int input) {

	}

	public void coupling(double b1, Model m, Event e) {
		Model press = models.get(0);
		Model drill = models.get(1);
		globalTime += m.ta();
		if (m == this) {
			e.setModel(press);
			press.deltaext(globalTime - b1, 1);
			e.setType(EventType.INT);
			pq.add(e);
		} else if (m.equals(press)) {
			e.setModel(drill);
			e.setTime(globalTime);
			e.setType(EventType.INT);
			press.deltaint();
			drill.deltaext(globalTime - b1, 1);
			pq.add(e);
		} else if (m.equals(drill)) {
			drill.deltaint();
			output = 1;
		}
	}

	public double getGlobalTime() {
		return globalTime;
	}

	public void setGlobalTime(double gblTime) {
		globalTime = gblTime;
	}

	public PQ<Event> getPq() {
		return pq;
	}

	public boolean equals(Model m) {
		return name.equals(m.getName());
	}
}
