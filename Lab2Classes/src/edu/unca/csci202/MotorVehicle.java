package edu.unca.csci202;

public abstract class MotorVehicle {

	private String make;
	private String model;
	private int odemeter;
	private int year;

	// abstract method
	abstract void purchase(Person owner);

	abstract void travel(int distance);

	// constructors
	public MotorVehicle() {

	}

	public MotorVehicle(String make, String model, int odemeter, int year) {
		this.make = make;
		this.model = model;
		this.odemeter = odemeter;
		this.year = year;
	}

	// getters
	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public int getOdemeter() {
		return odemeter;
	}

	public int getYear() {
		return year;
	}

	// setters
	public void setMake(String make) {
		this.make = make;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setOdemeter(int odemeter) {
		this.odemeter = odemeter;
	}

	public void setYear(int year) {
		this.year = year;
	}

	// toString()
	public String toString() {
		return year + " " + make + " " + model + " with " + odemeter + " mi";
	}
}
