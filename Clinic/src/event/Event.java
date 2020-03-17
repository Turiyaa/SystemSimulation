package event;

import atomic.Model;

public class Event implements Comparable<Event> {

	public enum EventType {
		INT, EXT, CON
	}

	private double time;
	private Model model;
	private EventType type;

	public Event(double t, Model m, EventType type) {
		this.time = t;
		this.model = m;
		this.type = type;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	@Override
	public int compareTo(Event e) {
		if (time < e.time)
			return -1;
		else if (time > e.time)
			return 1;
		else
			return 0;
	}

}
