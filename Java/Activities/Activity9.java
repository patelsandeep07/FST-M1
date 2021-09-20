package activities;

import java.util.ArrayList;

public class Activity9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// declaring arraylist
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("Delhi");
		myList.add("Mumbai");
		myList.add("Pune");

		// adding object at specific index
		myList.add(3, "Jaipur");
		myList.add(1, "Surat");

		System.out.println("Print all the object");
		for (String name : myList) {
			System.out.println(name);
		}

		System.out.println("3rd Element in the list is: " + myList.get(2));
		System.out.println("Is Banglore in the list: " + myList.contains("Banglore"));
		System.out.println("Size of the Arraylist is: " + myList.size());

		myList.remove("Surat");
		System.out.println("Size of the Arraylist is: " + myList.size());

	}

}
