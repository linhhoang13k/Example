package exercise52;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class LongestWordTest {

	private LongestWord underTest;
	
	@Before
	public void setup() {
		underTest = new LongestWord();
	}

	@Test
	public void shouldReturnSteadyFromReadySteadyGo() {
		assertThat(underTest.longestWord("ready, steady, go"), is("steady"));
	}
	
	@Test
	public void shouldReturnSteadyFromReadySteadyGoWithConfoundingBrackets() {
		assertThat(underTest.longestWord("ready[[[, steady, go"), is("steady"));
	}
	
	@Test
	public void shouldReturnOriginalStringFromSingleWord() {
		assertThat(underTest.longestWord("ABcd"), is("ABcd"));
	}
	
	@Test
	public void shouldReturnElephantFromConfusingString() {
		assertThat(underTest.longestWord("ele111pha]], lionmae, giraffe, elephant"), is("elephant"));
	}
}
