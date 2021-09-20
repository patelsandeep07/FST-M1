package activities;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car audi = new Car();
		// Initializing variable from Car Class
		audi.make = 2014;
		audi.color = "Black";
		audi.transmission = "Manual";

		// Car class methods
		audi.displayCharacteristics();
		audi.accelarate();
		audi.brake();
	}

}
