package activities;

public class MountainBike extends Bicycle {

	public int seatHeight;

	// MountainBike constructor
	public MountainBike(int gears, int speed, int startHeight) {
		// invoking base class constructor
		super(gears, speed);
		seatHeight = startHeight;
	}

	public void setHeight(int newValue) {
		seatHeight = newValue;
	}

	@Override
	public String bicycleDesc() {
		return (super.bicycleDesc() + "\nSeat Height is " + seatHeight);
	}
}
