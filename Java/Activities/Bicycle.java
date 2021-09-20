package activities;

public class Bicycle implements BicycleParts, BicycleOperations {

	public int gears;
	public int speed;

	public Bicycle(int gears, int speed) {
		this.gears = gears;
		this.speed = speed;
	}

	@Override
	public void applyBrake(int decrement) {
		// TODO Auto-generated method stub
		speed -= decrement;
		System.out.println("Current Speed: " + speed);
	}

	@Override
	public void speedUp(int increment) {
		// TODO Auto-generated method stub
		speed += increment;
		System.out.println("Current Speed: " + speed);
	}

	// info of bicycle
	public String bicycleDesc() {
		return ("No. of gears are " + gears + "\nSpeed of bicycle is " + speed);
	}


}
