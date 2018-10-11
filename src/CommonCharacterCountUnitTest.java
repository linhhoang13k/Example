package smooth.saling;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CommonCharacterCountUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {
		String s1 = "aabcc";
		String s2 = "adcaa";

		int result = commonCharacterCount(s1, s2);

		assertTrue(result == 3);
	}

	int commonCharacterCount(String s1, String s2) {				
		
		List<Character> characterOne = transformToList(s1);
		List<Character> characterTwo = transformToList(s2);
		int characterCount = 0;
		
		for (int i = 0; i < characterOne.size(); i++) {
			char character = characterOne.get(i);
			
			int positionCharacterInS2 = characterTwo.indexOf(character);
			
			if (positionCharacterInS2 > -1) {
				characterTwo.remove(positionCharacterInS2);

				characterCount++;
			}
		}

		return characterCount;
	}

	private List<Character> transformToList(String s) {
		List<Character> charList = new ArrayList<Character>();
		for (int i = 0; i < s.length(); i++) {
			charList.add(s.charAt(i));
		}
		return charList;
	}

}
