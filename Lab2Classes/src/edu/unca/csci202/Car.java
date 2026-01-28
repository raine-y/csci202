package edu.unca.csci202;

public class Car extends MotorVehicle {
	private boolean isFourWheelDrive;
	private Person owner = null;

	// methods
	void purchase(Person owner) {
		this.owner = owner;
	}

	void travel(int distance) {
		try {
			if (owner == null)
				throw new MotorVehicleException("anti-theft measures");
			else {
				System.out.println(owner.getName() + " traveled " + distance + " mi in their " + getMake());
			}
		} catch (MotorVehicleException e) {
			System.out.println("You can't travel in an un-owned car " + e);
		}

	}

	// constructors
	public Car() {

	}

	public Car(String make, String model, int odemeter, int year, boolean isFourWheelDrive) {
		super(make, model, odemeter, year);
		this.isFourWheelDrive = isFourWheelDrive;
	}

	public Car(String make, String model, int odemeter, int year, boolean isFourWheelDrive, Person owner) {
		super(make, model, odemeter, year);
		this.isFourWheelDrive = isFourWheelDrive;
		this.owner = owner;
	}

	// getters
	public boolean getFourWheel() {
		return isFourWheelDrive;
	}

	public Person getOwner() {
		return owner;
	}

	// setters
	public void setFourWheel(boolean isFourWheelDrive) {
		this.isFourWheelDrive = isFourWheelDrive;
	}

	public String toString() {
		return super.toString() + "\nOwned by: " + owner + "\nFour wheel drive: " + isFourWheelDrive;
	}
}
