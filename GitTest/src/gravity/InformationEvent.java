package gravity;

import java.util.EventObject;

public class InformationEvent extends EventObject {

	private double mass;
	private double xV;
	private double yV;
	private String shape;
	private boolean clear;
	
	public InformationEvent(Object source, double mass, double xV, double yV, String shape, boolean clear) {
		super(source);

		this.mass = mass;
		this.xV = xV;
		this.xV = xV;
		this.shape = shape;
		this.clear = clear;
		
	}

	public double getMass() {
		return mass;
	}

	public double getxV() {
		return xV;
	}

	public double getyV() {
		return yV;
	}

	public String getShape() {
		return shape;
	}

	public boolean isClear() {
		return clear;
	}
	
}
