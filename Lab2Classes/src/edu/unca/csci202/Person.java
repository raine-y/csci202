package edu.unca.csci202;

public class Person {
	// attributes
		private String name, country;
		private int age;

		// constructors
		public Person() {
		}

		public Person(String name, String country, int age) {
			this.name = name;
			this.country = country;
			this.age = age;
		}

		// getters
		public String getName() {
			return name;
		}

		public String getCountry() {
			return country;
		}

		public int getAge() {
			return age;
		}

		// setters
		public void setName(String name) {
			this.name = name;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String toString() {
			return name + ", " + age + ". From " + country;
		}
}
