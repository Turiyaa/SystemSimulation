package networkmodel;

import java.util.ArrayList;
import java.util.List;

import atomic.Model;
import event.Event;
import event.Event.EventType;

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
			System.out.println("Output: time = " + globalTime + " Patient\n");
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
		Model register = models.get(0);
		Model NR1 = models.get(1);
		Model NR2 = models.get(2);
		Model Doc = models.get(3);
		if (m == this) {
			e.setModel(register);
			register.deltaext(globalTime - b1, 1);
			e.setType(EventType.INT);
			pq.add(e);
		} else if (m.equals(register)) {
			globalTime += m.ta();
			if (count(NR1.getName()) <= count(NR2.getName())) {
				e.setModel(NR1);
				register.deltaint();
				NR1.deltaext(globalTime - b1, 1);
			} else {
				e.setModel(NR2);
				register.deltaint();
				NR2.deltaext(globalTime - b1, 1);
			}
			e.setType(EventType.INT);
			e.setTime(globalTime);
			pq.add(e);

		} else if (m.equals(NR1) || m.equals(NR2)) {

			if (m.equals(NR1)) {
				globalTime += m.ta();
				NR1.deltaint();
				Doc.deltaext(globalTime - b1, 1);
			} else {
				NR2.deltaint();
				Doc.deltaext(globalTime - b1, 1);
			}
			e.setModel(Doc);
			e.setTime(globalTime);
			e.setType(EventType.INT);
			pq.add(e);

		} else if (m.equals(Doc)) {
			globalTime += m.ta();
			Doc.deltaint();
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

	public int count(String str) {
		int counter = 0;
		for (int i = 1; pq.size() >= i; i++) {
			if (pq.getEvent(i).getModel().getName().equals(str)) {
				counter++;
			}
		}
		return counter;
	}
}
