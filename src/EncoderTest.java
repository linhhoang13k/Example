package exercise49;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class EncoderTest {

	private Encoder underTest;
	
	@Before
	public void setup() {
		underTest = new Encoder();
	}
	
	@Test
	public void shouldReturn2a3bcFromAabbbc() {
		assertThat(underTest.lineEncoding("aabbbc"), is("2a3bc"));
	}

	@Test
	public void shouldReturnA2bca2bFromAbbcabb() {
		assertThat(underTest.lineEncoding("abbcabb"), is("a2bca2b"));
	}
	
	@Test
	public void shouldReturnAbcdFromAbcd() {
		assertThat(underTest.lineEncoding("abcd"), is("abcd"));
	}
}
