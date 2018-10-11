package exercise55;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GridViewTest {

	private GridView underTest;

	@Before
	public void setup() {
		underTest = new GridView();
	}

	@Test
	public void shouldReturn6DifferentSquaresTestCase1() {
		int[][] matrix = { { 1, 2, 1 }, { 2, 2, 2 }, { 2, 2, 2 }, { 1, 2, 3 }, { 2, 2, 1 } };
		assertThat(underTest.differentSquares(matrix), is(6));
	}

	@Test
	public void shouldReturn1SquareTestCase2() {
		int[][] matrix = { { 9, 9, 9, 9, 9 }, { 9, 9, 9, 9, 9 }, { 9, 9, 9, 9, 9 }, { 9, 9, 9, 9, 9 },
				{ 9, 9, 9, 9, 9 } };
		assertThat(underTest.differentSquares(matrix), is(1));
	}

	@Test
	public void shouldReturn0SquaresTestCase3() {
		int[][] matrix = { { 3 } };

		assertThat(underTest.differentSquares(matrix), is(0));
	}

	@Test
	public void shouldReturn0SquaresTestCase4() {
		int[][] matrix = { { 3, 4, 5, 6, 7, 8 } };

		assertThat(underTest.differentSquares(matrix), is(0));
	}

	@Test
	public void shouldReturn0SquaresTestCase5() {
		int[][] matrix = { { 3 }, { 4 }, { 5 }, { 6 }, { 7 }, { 8 } };

		assertThat(underTest.differentSquares(matrix), is(0));
	}

	@Test
	public void shouldReturn54SquaresTestCase6() {
		int[][] matrix = { { 2, 5, 3, 4, 3, 1, 3, 2 }, { 4, 5, 4, 1, 2, 4, 1, 3 }, { 1, 1, 2, 1, 4, 1, 1, 5 },
				{ 1, 3, 4, 2, 3, 4, 2, 4 }, { 1, 5, 5, 2, 1, 3, 1, 1 }, { 1, 2, 3, 3, 5, 1, 2, 4 },
				{ 3, 1, 4, 4, 4, 1, 5, 5 }, { 5, 1, 3, 3, 1, 5, 3, 5 }, { 5, 4, 4, 3, 5, 4, 4, 4 } };

		assertThat(underTest.differentSquares(matrix), is(54));
	}
}
