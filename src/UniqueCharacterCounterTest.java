package exercise36;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class UniqueCharacterCounterTest {

	private UniqueCharacterCounter underTest;

	@Before
	public void setup() {
		underTest = new UniqueCharacterCounter();
	}

	@Test
	public void shouldReturn3FromAbc() {
		assertThat(underTest.differentSymbolsNaive("abc"), is(3));
	}

	@Test
	public void shouldReturn4FromAbcdabc() {
		assertThat(underTest.differentSymbolsNaive("abcdabc"), is(4));
	}

	@Test
	public void shouldReturn2FromAba() {
		assertThat(underTest.differentSymbolsNaive("aba"), is(2));
	}
}
