package numbers;

import java.util.Scanner;

public class ClosestSeq {

	public int closestSequence(int a[], int b[]) {
		int lenA = a.length;
		int lenB = b.length;

		int mat[][] = new int[lenA][lenB];

		// first element
		mat[0][0] = Math.abs(a[0] - b[0]);

		// fill differences in rest of the first row
		for (int j = 1; j <= lenB - lenA; j++) {
			int diff = Math.abs(a[0] - b[j]);
			// store minimum value at every iteration from previous
			mat[0][j] = min(diff, mat[0][j - 1]);
		}

		// fill rest of the matrix
		for (int i = 1; i < lenA; i++) {
			for (int j = i; j <= lenB - lenA + i; j++) {
				int diff = Math.abs(a[i] - b[j]) + mat[i - 1][j - 1];
				if (i == j) {
					mat[i][j] = diff;
				} else {
					mat[i][j] = min(diff, mat[i][j - 1]);
				}
			}
		}

		return mat[lenA - 1][lenB - 1];
	}

	private int min(int diff, int num) {
		return (diff < num) ? diff : num;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int i = 0;

		System.out.println("Enter length of first array = ");
		int lenA = in.nextInt();

		System.out.println("Enter first array = ");
		int a[] = new int[lenA];
		while (i != lenA) {
			a[i++] = in.nextInt();
		}

		i = 0;

		System.out.println("Enter length of second array = ");
		int lenB = in.nextInt();
		System.out.println("Enter second array = ");
		int b[] = new int[lenB];
		while (i != lenB) {
			b[i++] = in.nextInt();
		}

		ClosestSeq cs = new ClosestSeq();
		int minDiffInSeq = cs.closestSequence(a, b);
		System.out.println("minimum difference in sequence = " + minDiffInSeq);
	}

}
