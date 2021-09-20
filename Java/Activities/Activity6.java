package activities;

public class Activity6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// plane with max passenger
		Plane plane = new Plane(10);

		plane.onboard("SSP");
		plane.onboard("NSP");
		plane.onboard("PSP");

		// plane takes off
		System.out.println("Plane took off at: " + plane.takeOff());

		// Print list of people on board
		System.out.println("People on the plane: " + plane.getPassengers());

		// Flying
		Thread.sleep(5000);

		// Plane has landed
		plane.land();

		// plane lands
		System.out.println("Plane landed at: " + plane.getLastTimeLanded());

		System.out.println("People on plane after landing: " + plane.getPassengers());
	}

}
