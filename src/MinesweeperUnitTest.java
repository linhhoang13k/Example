package island.of.knowledge;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MinesweeperUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test3() {
		boolean[][] matrix = { { true, false, false, true }, { false, false, true, false }, { true, true, false, true }

		};

		int[][] result = minesweeper(matrix);

		assertTrue(result[0][2] == 2);
		assertTrue(result[1][1] == 4);
		assertTrue(result[2][2] == 3);
	}

	int[][] minesweeper(boolean[][] matrix) {

		int[][] numericMatrix = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				numericMatrix[i][j] = calculaMines(i, j, matrix);

			}
		}

		return numericMatrix;
	}

	int calculaMines(int i, int j, boolean[][] matrix) {

		int mines = 0;

		// mines = mines + transformCell(matrix[i][j]);

		if (i < (matrix.length - 1)) {
			mines = mines + transformCell(matrix[i + 1][j]);
		}

		if (i > 0) {
			mines = mines + transformCell(matrix[i - 1][j]);
		}

		if (j < (matrix[i].length - 1)) {
			mines = mines + transformCell(matrix[i][j + 1]);
		}

		if (j > 0) {
			mines = mines + transformCell(matrix[i][j - 1]);
		}

		if (i > 0 && j > 0) {
			mines = mines + transformCell(matrix[i - 1][j - 1]);
		}

		if (i < (matrix.length - 1) && j < (matrix[i].length - 1)) {
			mines = mines + transformCell(matrix[i + 1][j + 1]);
		}

		if (i > 0 && j < (matrix[i].length - 1)) {
			mines = mines + transformCell(matrix[i - 1][j + 1]);
		}

		if (j > 0 && i < (matrix.length - 1)) {
			mines = mines + transformCell(matrix[i + 1][j - 1]);
		}

		return mines;
	}

	int transformCell(boolean cell) {
		return cell ? 1 : 0;
	}

}
