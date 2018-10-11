package island.of.knowledge;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class IsIPv4AddressUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {
		String inputString = "172.16.254.1";

		boolean result = isIPv4Address(inputString);

		assertTrue(result);
	}

	@Test
	public void test17() {
		String inputString = "0..1.0.0";

		boolean result = isIPv4Address(inputString);

		assertFalse(result);
	}

	boolean isIPv4Address(String inputString) {
		
		String[] ipv4Parts = inputString.split("\\.");
		
		if(ipv4Parts.length!=4)
			return false;

		long pieces = Arrays.asList(ipv4Parts).stream()
				.filter(piece -> {
					try {
						int pieceInteger = Integer.parseInt(piece);

						return pieceInteger <= 255;
					}catch(NumberFormatException e) {
						return false;
					}

				}).count();

		return pieces == 4;
	}
}
