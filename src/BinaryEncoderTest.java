package exercise58;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BinaryEncoderTest {

	private BinaryEncoder underTest;
	
	@Before
	public void setup() {
		underTest = new BinaryEncoder();
	}
	
	@Test
	public void shouldReturnHelloFrom8BitBinaryTestCase1() {
		assertThat(underTest.messageFromBinaryCode("010010000110010101101100011011000110111100100001"), is("Hello!"));
	}
	
	@Test
	public void shouldReturnStarWarsReferenceFrom8BitBinaryTestCase2() {
		String code = "01001101011000010111100100100000011101000110100001100101001000000100011001101111011100100110001101100101001000000110001001100101001000000111011101101001011101000110100000100000011110010110111101110101";
		String message = "May the Force be with you";
		assertThat(underTest.messageFromBinaryCode(code), is(message));
	}
	
	@Test
	public void shouldReturnYouHadMeAtHelloFrom8BitBinaryTestCase3() {
		String code = "010110010110111101110101001000000110100001100001011001000010000001101101011001010010000001100001011101000010000001100000011010000110010101101100011011000110111100101110";
		String message = "You had me at `hello.";
		assertThat(underTest.messageFromBinaryCode(code), is(message));
	}
}
