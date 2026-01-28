package edu.unca.csci202;

public class Plane extends MotorVehicle {
	private int wingspan;
	private Person owner;

	// methods
	void purchase(Person owner) {
		this.owner = owner;
	}

	void travel(int distance) {
		try {
			if (owner == null)
				throw new MotorVehicleException("anti-theft measures");
			else {
				System.out.println(owner.getName() + " traveled " + distance + " nautical mi in their " + getMake());
			}
		} catch (MotorVehicleException e) {
			System.out.println("You can't travel in an un-owned plane " + e);
		}
	}

	// constructors
	public Plane() {

	}

	public Plane(String make, String model, int odemeter, int year, int wingspan) {
		super(make, model, odemeter, year);
		this.wingspan = wingspan;
	}

	public Plane(String make, String model, int odemeter, int year, int wingspan, Person owner) {
		super(make, model, odemeter, year);
		this.wingspan = wingspan;
		this.owner = owner;
	}

	// getters
	public int getWingspan() {
		return wingspan;
	}
	
	public Person getOwner() {
		return owner;
	}
	
	// setters
	
	public void setWingspan(int wingspan) {
		this.wingspan = wingspan;
	}
	
	public String toString() {
		return super.toString() + "\nOwned by: " + owner + "\nWingspan: " + wingspan + " ft";
	}
}
