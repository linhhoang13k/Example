package com.iub.coding.practice.CodeName47;

public class RemoveDuplicate {
	void printRepeating(int arr[], int size) {
		int i;
		System.out.println("The repeating elements are : ");

		for (i = 0; i < size; i++) {
			System.out.println(Math.abs(arr[i]));
			if (arr[Math.abs(arr[i])] > 0)
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			/*
			 * else System.out.print(Math.abs(arr[i]) + " ");
			 */
		}
	}

	/* Driver program to test the above function */
	public static void main(String[] args) {
		RemoveDuplicate duplicate = new RemoveDuplicate();
		int arr[] = { 4, 3, 4, 5, 2, 3, 1 };
		int arr_size = arr.length;
		//duplicate.printRepeating(arr, arr_size);

		//System.out.println(Math.abs(-1));
		
		System.out.println(searchWithXOR(arr));
	}

	public static int searchWithXOR(int[] array) {

		int dup = 0;

		int offset = 1;

		for (int i = 0; i < array.length; i++) {

			dup = dup ^ (array[i] + offset) ^ i;

		}

		return dup - offset;

	}

}
