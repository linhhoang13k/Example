package algo;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AlphaNumericLessTest {

	AlphaNumericLess testedObj = new AlphaNumericLess();

	/**
	 * {"string1", "string2", true/false}
	 */
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { "a", "a1", true },
				{ "ab", "a1", false }, { "b", "a1", false },
				{ "x11y012", "x011y13", true }, { "ab000144", "ab144", true },
				{ "000", "0000", false }, { "abc123", "abc123", false },
				{ "zza1233", "zza1234", true }, { "zzz1", "zzz1", false },
				{ "00", "a2", true }, { "000000", "a2", true },
				{ "a001b02", "a01b002", true }

		});
	}

	@Parameter(0)
	public String string1;

	@Parameter(1)
	public String string2;

	@Parameter(2)
	public boolean expected;

	@Test
	public void testAlphanumericLess() throws Exception {
		System.out.println(string1 + " " + string2);
		assertEquals(expected, testedObj.alphanumericLess(string1, string2));
	}

}
