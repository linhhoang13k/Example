package com.iub.coding.practice.CodeName47;

public class PascleTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 6;
		int data[][] = new int[n][2 * n - 1];

		data[0][n] = 1;

		int data2[] = new int[2 * n - 1];
		data2[n] = 1;

		printTriangle(data);
	}

	public static void printTriangle(int data[][]) {

		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[1].length; j++) {

				sum = data[i][j];

				if (i > 0) {
					if (j > 0) {
						sum += data[i - 1][j - 1];

					}
					if (j < data[1].length - 1) {
						sum += data[i - 1][j + 1];
					}

					data[i][j] = sum;
				}

				if (sum > 0)
					System.out.print(sum);
				else
					System.out.print(" ");

				sum = 0;

			}

			System.out.println();
		}
	}

	public static void printTriangle1DArray(int data[], int level) {

		int sum = 0;
		for (int i = 0; i < level; i++) {
			for (int j = 0; j < data.length; j++) {

				if (i > 0) {
					if (j > 0) {
						sum += data[j - 1];

					}
					if (j < data.length - 1) {
						sum += data[j + 1];
					}

					data[j] = sum;
					if(sum > 0)
						j++;	
				} else {
					sum = data[j];
				}

				if (sum > 0)
					System.out.print(sum);
				else
					System.out.print(" ");

				sum = 0;

			}

			System.out.println();
		}
	}

}
