package atomic;

import java.text.DecimalFormat;

public class Atomic implements Model {
	private String name;
	private double time;
	private int patients;
	private double remainingTime;
	
	
	public Atomic(String n, double t) {
		this.name = n;
		this.time = t;
		this.patients = 0;
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
		patients -= 1;
		remainingTime = time;
	}

	@Override
	public void deltaext(double e, int input) {
		if(patients > 0) {
			patients +=input;
			remainingTime -=e;
		}else {
			patients+=input;
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
		return patients > 0 ? format(remainingTime) : Double.POSITIVE_INFINITY;

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
		str = name+" = "+"("+patients+", "+time+")";
		return str;
		
	}

	@Override
	public boolean equals(Model m) {
		return name.equals(m.getName());
	}
}
