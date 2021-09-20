package activities;

import java.util.Arrays;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// given Array
		int[] numArr = { 10, 77, 10, 54, -11, 10 };
		System.out.println("Original Array: " + Arrays.toString(numArr));

		// required number from array
		int reqNum = 10;
		int sumOfNum = 30;

		System.out.println("Result: " + result(numArr, reqNum, sumOfNum));

	}

	public static boolean result(int[] numbers, int reqNum, int sumOfNum) {

		int tempSum = 0;
		for (int number : numbers) {

			if (reqNum == number) {

				tempSum = tempSum + number;
			}
		}

		return tempSum == sumOfNum;
	}

}


