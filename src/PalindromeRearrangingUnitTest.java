package exploringtwo.the.waters;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class PalindromeRearrangingUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {
		String inputString = "aabb";

		boolean result = palindromeRearranging(inputString);

		assertTrue(result);
	}

	boolean palindromeRearranging(String inputString) {
		
		Map<String, Integer> countsLettersMap = new HashMap<>();
		int stringSize = inputString.length();
		
		for(int i=0; i<stringSize; i++) {
			String letter = String.valueOf(inputString.charAt(i));

			int letterCount = 1;
			
			if(countsLettersMap.containsKey(letter)) {
				letterCount = countsLettersMap.get(letter)+1;
			}
				
			countsLettersMap.put(letter, letterCount);
		}
			
		long oddCount = countsLettersMap.values().stream().filter(count -> count % 2 !=0).count();

		
		if(stringSize%2==0) {
			return oddCount==0;
		}else {
			return oddCount==1;
		}

	}

}
