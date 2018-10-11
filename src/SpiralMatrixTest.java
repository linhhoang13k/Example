package exercise59;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class SpiralMatrixTest {

	private SpiralMatrix underTest;

	@Before
	public void setup() {
		underTest = new SpiralMatrix();
	}

	@Test
	public void shouldReturn3By3MatrixFrom3TestCase1() {
		int[][] spiralMatrix = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
		assertThat(underTest.spiralNumbers(3), is(spiralMatrix));
	}

	@Test
	public void shouldReturn5By5MatrixFrom5TestCase1() {
		int[][] spiralMatrix = { { 1, 2, 3, 4, 5 }, { 16, 17, 18, 19, 6 }, { 15, 24, 25, 20, 7 }, { 14, 23, 22, 21, 8 },
				{ 13, 12, 11, 10, 9 } };
		assertThat(underTest.spiralNumbers(5), is(spiralMatrix));
	}

}
