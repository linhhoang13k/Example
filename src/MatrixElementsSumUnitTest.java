package edge.of.the.ocean.phase;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MatrixElementsSumUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void invertedMatrix_ok() {
		int[][] matrix = new int[][] { { 0, 1, 1, 2 }, { 0, 5, 0, 0 }, { 2, 0, 3, 3 } };

		int[][] invertedMatrix = investMatrix(matrix);

		System.out.println(invertedMatrix.length);

		assertTrue(invertedMatrix.length == 4);
		assertTrue(invertedMatrix[0].length == 3);
		assertTrue(invertedMatrix[0][2] == 2);
	}

	@Test
	public void test1() {
		int[][] matrix = new int[][] { { 0, 1, 1, 2 }, { 0, 5, 0, 0 }, { 2, 0, 3, 3 } };

		int result = matrixElementsSum(matrix);

		assertTrue(result == 9);
	}

	@Test
	public void test2() {
		int[][] matrix = new int[][] { { 1, 1, 1, 0 }, { 0, 5, 0, 1 }, { 2, 1, 3, 10 } };

		int result = matrixElementsSum(matrix);

		assertTrue(result == 9);
	}

	int matrixElementsSum(int[][] matrix) {

		int[][] invertedMatrix = investMatrix(matrix);

		int sum = 0;

		for (int row = 0; row < invertedMatrix.length; row++) {
			sum = sum + rowElementSum(invertedMatrix[row]);
		}

		return sum;
	}

	int rowElementSum(int[] row) {

		int sum = row[0];

		boolean suitable = row[0] == 0 ? false : true;

		for (int i = 1; i < row.length; i++) {
			if (suitable && row[i] > 0 && row[i - 1] > 0) {
				sum = sum + row[i];
			} else if (row[i] == 0) {
				suitable = false;
			}
		}

		return sum;
	}


	int[][] investMatrix(int[][] matrix) {
		int[][] invertedMatrix = new int[matrix[0].length][matrix.length];

		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {

				invertedMatrix[column][row] = matrix[row][column];
			}
		}

		return invertedMatrix;
	}
}
