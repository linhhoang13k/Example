package exercise34;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class KthArrayExtractorTest {

	private KthArrayExtractor underTest;

	@Before
	public void setup() {
		underTest = new KthArrayExtractor();
	}

	@Test
	public void shouldReturn1Through10WithKth3Extracted() {
		int[] inputArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] afterExtraction = { 1, 2, 4, 5, 7, 8, 10 };
		assertThat(underTest.extractEachKth(inputArray, 3), is(afterExtraction));
	}

	@Test
	public void shouldReturnEmptyArray() {
		int[] inputArray = { 1, 1, 1, 1, 1 };
		int[] afterExtraction = {};
		assertThat(underTest.extractEachKth(inputArray, 1), is(afterExtraction));
	}
}
