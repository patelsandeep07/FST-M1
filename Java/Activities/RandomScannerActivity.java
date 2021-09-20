package activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomScannerActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		Random indexGen = new Random();

		System.out.println("Enter integer please ");
		System.out.println("Terminate using non integer ");

		while (scan.hasNextInt()) {
			list.add(scan.nextInt());
		}

		// convert Arraylist to Array
		Integer nums[] = list.toArray(new Integer[0]);
		int index = indexGen.nextInt(nums.length);

		System.out.println("Generted Index value: " + index);
		System.out.println("Value of array at generated index: " + nums[index]);

		scan.close();
	}

}
