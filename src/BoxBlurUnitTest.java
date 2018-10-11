package island.of.knowledge;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BoxBlurUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {
		int[][] image = { { 1, 1, 1 }, { 1, 7, 1 }, { 1, 1, 1 } };

		int[][] result = boxBlur(image);

		assertTrue(result[0][0] == 1);
	}

	@Test
	public void test3() {
		int[][] image = { { 36, 0, 18, 9 }, { 27, 54, 9, 0 }, { 81, 63, 72, 45 } };

		int[][] result = boxBlur(image);

		assertTrue(result[0][0] == 40);
		assertTrue(result[0][1] == 30);
	}

	int[][] boxBlur(int[][] image) {

		int[][] result = new int[image.length - 2][image[0].length - 2];

		for (int i = 1; i < image.length - 1; i++) {
			for (int j = 1; j < image[i].length - 1; j++) {
				result[i - 1][j - 1] = calculateMiddlePixel(createSquare(image, i, j));
			}
		}

		return result;
	}

	int[][] createSquare(int[][] image, int i, int j) {
		int[][] result = new int[3][3];

		result[1][1] = image[i][j];
		result[0][1] = image[i - 1][j];
		result[2][1] = image[i + 1][j];

		result[1][0] = image[i][j - 1];
		result[0][0] = image[i - 1][j - 1];
		result[2][0] = image[i + 1][j - 1];

		result[1][2] = image[i][j + 1];
		result[0][2] = image[i - 1][j + 1];
		result[2][2] = image[i + 1][j + 1];

		return result;
	}

	int calculateMiddlePixel(int[][] image) {
		int result = (image[0][0] + image[0][1] + image[0][2] + image[1][0] + image[1][1] + image[1][2] + image[2][0]
				+ image[2][1] + image[2][2]) / 9;

		return result;
	}
}
