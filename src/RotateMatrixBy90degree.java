/* In place rotation of matrix by 90 Degrees */

public class RotateMatrixBy90Degree {

	public static void main(String[] args) {

		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 10, 11 } };

		int n = a.length - 1; // 3

		int iMove = 0, jMove = n, iStart = 0, iEnd = n, jStart = 0, jEnd = n;

		int k = n; // Initial moves
		int c = 0;
		while (iStart < iEnd && jStart < jEnd) {

			int i = iStart, j = jStart;
			k = n - c;  // After every completion of the outer layer of the matrix, k will decrement by 
			
			iMove = 0;  // In the beginning i move is 0
			jMove = k;			// jMove is k

			while (k > 0) {     // k denotes number of elements which needs to be moved in each row
				int t = a[i][j];  // Store the value which needs to be moved
				int counter = 0;    // We need to cover 4 corners, counter will store the value of how many corners got covered.
				
				while (counter < 4) {

					if (counter == 3)
						jMove = Math.abs(jMove);

					if (counter == 1 || counter == 2) {   // In counter 1 j can be both same or it can decrement, In counter 2 it definitely has to decrement
						if (jMove > 0)
							jMove = -jMove;
					}
					
					int buff = a[i + iMove][j + jMove];

					a[i + iMove][j + jMove] = t;

					j = j + jMove;  	// update j value
					i = i + iMove;      // update i value

					if (counter >= 1) {
						if(iMove > 0)
						iMove = -iMove;     // iMove will now decrement as row number is now going to decrement
					}
					int temp = iMove;  // swapping values of iMove and jMove
					iMove = jMove;
					jMove = temp;
					t = buff;
					counter++;
				}

				jMove = Math.abs(jMove);   
				iMove = Math.abs(iMove);
				j++;
				jMove--;
				i = iStart;
				iMove++;
				k--;
			}
			c += 2;   // After every outer layer is completed, c gets incremented by 2
			iStart++;
			iEnd--;
			jStart++;
			jEnd--;
		}

		for (int i = 0; i < a.length; i++) {

			for (int j = 0; j < a[i].length; j++) {

				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

}
