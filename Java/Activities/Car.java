package activities;

public class Car {

	// Variable
	String color, transmission;
	int make, tyres, doors;

	// constructor
	public Car() {

		tyres = 4;
		doors = 4;
	}

	// Methods
	public void displayCharacteristics() {
		System.out.println("Color of the Car is: " + color);
		System.out.println("Transmission of the Car is: " + transmission);
		System.out.println("Make of the Car is: " + make);
		System.out.println("No. of tyres on the car is: " + tyres);
		System.out.println("No. of doors on the car is: " + doors);
	}

	public void accelarate() {
		System.out.println("Car is moving forward.");
	}

	public void brake() {
		System.out.println("Car has stopped.");
	}
}
