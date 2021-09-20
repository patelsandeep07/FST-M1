package activities;

import java.util.HashMap;

public class Activity11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<Integer, String> colour = new HashMap<Integer, String>();

		colour.put(1, "Violet");
		colour.put(2, "Indigo");
		colour.put(3, "Blue");
		colour.put(4, "Green");
		colour.put(5, "Yellow");
		colour.put(6, "Orange");
		colour.put(7, "Red");

		// Print the HashMap
		System.out.println("Original HAshMap: " + colour);

		// Remove one colour
		colour.remove(4);

		// Map after removing colour
		System.out.println("Updated HashMap: " + colour);

		// Check if Red Exist
		if (colour.containsValue("Red")) {
			System.out.println("Red exists in Map");
		} else {
			System.out.println("Red Does not exists in Map");
		}

		// Print size of the MAP
		System.out.println("Sixe of the Map: " + colour.size());

	}

}
