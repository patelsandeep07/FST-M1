package activities;

import java.util.HashSet;

public class Activity10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashSet<String> hs = new HashSet<String>();
		// Adding element to HashSet
		hs.add("S1");
		hs.add("S2");
		hs.add("S3");
		hs.add("S4");
		hs.add("S5");

		// print hashset
		System.out.println("Original HashSet: " + hs);

		// print size of hashset
		System.out.println("Size of HashSet: " + hs.size());

		// Remove element
		System.out.println("Remove S3 from the Set: " + hs.remove("S3"));

		// Remove Element that is not present
		if (hs.remove("S6")) {
			System.out.println("S6 is Remove from Set");
		} else {
			System.out.println("S6 is not present in Set");
		}

		// Search for an element
		System.out.println("Checking if S4 is present: " + hs.contains("S4"));

		// Print updated Set
		System.out.println("Updated HashSet: " + hs);
	}

}
