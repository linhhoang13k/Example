package smooth.saling;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AllLongestStringsUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {

		String[] inputArray = { "aba", "aa", "ad", "vcd", "aba" };

		String[] result = allLongestStrings(inputArray);

		assertTrue("aba".equals(result[0]));
		assertTrue("vcd".equals(result[1]));
		assertTrue("aba".equals(result[2]));
	}

	String[] allLongestStrings(String[] inputArray) {

		int maxLongestString = calculateMaxLongestString(inputArray);

		List<String> resultList = new ArrayList<>();

		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i].length() == maxLongestString) {
				resultList.add(inputArray[i]);
			}
		}

		return resultList.toArray(new String[resultList.size()]);
	}

	private int calculateMaxLongestString(String[] inputArray) {
		int maxLongestString = 0;

		for (String element : inputArray) {
			if (element.length() > maxLongestString)
				maxLongestString = element.length();
		}

		return maxLongestString;
	}

}
