package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import main.MatrixElementsSum;

public class MatrixElementsSumTest {

	private int matrixResult(int[][] matrix) {
		return MatrixElementsSum.matrixElementsSum(matrix);
	}

	@Test
	public void shouldSumAllElementsWhenNoZerosOccur() {
		int[][] matrix = { { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 } };
		assertThat(matrixResult(matrix), is(18));
	}

	@Test
	public void shouldNotSumAnyColumnIfFirstElementIsZero() {
		int[][] matrix = { { 0, 1, 3 }, { 0, 2, 3 }, { 0, 2, 2 } };
		assertThat(matrixResult(matrix), is(13));
	}

	@Test
	public void shouldNotSumRestOfColumnsIfSecondElementIsZero() {
		int[][] matrix = { { 1, 1, 3, 4, 5 }, { 0, 0, 0, 0, 0 }, { 2, 0, 4, 5, 6 } };
		assertThat(matrixResult(matrix), is(14));
	}

}
