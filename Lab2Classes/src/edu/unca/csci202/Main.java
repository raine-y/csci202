package edu.unca.csci202;

public class Main {
	public static void main(String[] args) {
		Person person1 = new Person("John", "USA", 47);
		System.out.println(person1.toString());
		
		Person person2 = new Person();
		person2.setName("Xihuan");
		person2.setCountry("China");
		person2.setAge(25);
		System.out.println(person2.toString());
		
		Car car1 = new Car("Hyundai", "Santa Fe ", 150000, 2011, true); // un-owned
		System.out.println(car1.toString());
		car1.travel(100); // distance
		car1.purchase(person1);
		System.out.println(car1.toString());
		car1.travel(100); // distance
		
		Plane plane1 = new Plane();
		plane1.setMake("Cesnna");
		plane1.setModel("Stationair");
		plane1.setOdemeter(28575);
		plane1.setYear(1963);
		plane1.setWingspan(36);
		System.out.println(plane1.toString());
		plane1.travel(17); // distance
		plane1.purchase(person2);
		System.out.println(plane1.toString());
		plane1.travel(17); // distance
	}
}
