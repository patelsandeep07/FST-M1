package activities;

import java.util.Arrays;

public class Activity4 {



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] data = { 7, 9, 3, 5, 2 };
		ascendingSort(data);
		System.out.println("Sorted Array in Ascending Order: ");
		System.out.println(Arrays.toString(data));
	}

	static void ascendingSort(int[] array) {
		int size = array.length, i, j, temp;
		for (i = 0; i < size; i++) {

			for (j = i + 1; j < size; j++) {

				temp = 0;

				if (array[i] > array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}

			}
		}

	}
}
