package exercise15;

import org.junit.Assert;
import org.junit.Test;

public class AsterikBorderTest {

	@Test
	public void testColumnLengthReturn() {
		// arrange
		AsterikBorder underTest = new AsterikBorder();
		// act
		String[] picture = new String[] { "bar" };
		int columns = underTest.columnLength(picture);
		// assert
		Assert.assertEquals(5, columns);
	}

	@Test
	public void convertColumnNumberToString() {
		AsterikBorder underTest = new AsterikBorder();
		String border = underTest.columnLengthToAsterik(5);
		Assert.assertEquals("*******", border);
	}

	@Test
	public void shiftStringAddAsterikOnEitherSide() {
		AsterikBorder underTest = new AsterikBorder();
		String withAsteriks = underTest.addAsterikFrontAndBack("bar");
		Assert.assertEquals("*bar*", withAsteriks);
	}

	@Test
	public void returnShiftedStringsWithTopAndBottomBorder() {
		AsterikBorder underTest = new AsterikBorder();
		String[] input = new String[3];
		input[0] = "foo";
		input[1] = "bar";
		input[2] = "baz";
		String[] response = underTest.addBorder(input);
		String[] correct = {"*****", "*foo*", "*bar*", "*baz*", "*****"};
		Assert.assertArrayEquals(correct, response );
	}

}
