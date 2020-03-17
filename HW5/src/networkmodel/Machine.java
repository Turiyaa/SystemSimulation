package networkmodel;

import java.text.DecimalFormat;

public class Machine implements Model {
	String name;
	double time;
	int parts;
	double remainingTime;
	
	
	public Machine(String n, double t) {
		this.name = n;
		this.time = t;
		this.parts = 0;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void lambda() {
	}

	@Override
	public void deltaint() {
		parts -= 1;
		remainingTime = time;
	}

	@Override
	public void deltaext(double e, int input) {
		if(parts > 0) {
			parts +=input;
			remainingTime -=e;
		}else {
			parts+=input;
			remainingTime = time;
		}
		
	}

	@Override
	public void deltacon(int q) {
		deltaint();
		deltaext(0.0,q);
	}

	@Override
	public double ta() {
		return parts > 0 ? format(remainingTime) : Double.POSITIVE_INFINITY;

	}
	
	public double format(double time) {
		DecimalFormat df = new DecimalFormat("###0.0");
		String val = df.format(time);
		time = Double.valueOf(val);
		return time;
	}
	@Override
	public String toString() {
		String str;
		str = name+" = "+"("+parts+", "+time+")";
		return str;
		
	}

	@Override
	public boolean equals(Model m) {
		return name.equals(m.getName());
	}
}
