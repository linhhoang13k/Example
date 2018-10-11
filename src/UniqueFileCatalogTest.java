package exercise57;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class UniqueFileCatalogTest {

	private UniqueFileCatalog underTest;

	@Before
	public void setup() {
		underTest = new UniqueFileCatalog();
	}

	@Test
	public void shouldReturnUniqueArrayTestCase1() {
		String[] input = { "doc", "doc", "image", "doc(1)", "doc" };
		String[] output = { "doc", "doc(1)", "image", "doc(1)(1)", "doc(2)" };
		assertThat(underTest.fileNaming(input), is(output));
	}

	@Test
	public void shouldReturnUniqueArrayTestCase2() {
		String[] input = { "a(1)", "a(6)", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a" };
		String[] output = { "a(1)", "a(6)", "a", "a(2)", "a(3)", "a(4)", "a(5)", "a(7)", "a(8)", "a(9)", "a(10)",
				"a(11)" };
		assertThat(underTest.fileNaming(input), is(output));
	}

	@Test
	public void shouldReturnUniqueArrayTestCase3() {
		String[] input = { "dd", "dd(1)", "dd(2)", "dd", "dd(1)", "dd(1)(2)", "dd(1)(1)", "dd", "dd(1)" };

		String[] output = { "dd", "dd(1)", "dd(2)", "dd(3)", "dd(1)(1)", "dd(1)(2)", "dd(1)(1)(1)", "dd(4)",
				"dd(1)(3)" };
		assertThat(underTest.fileNaming(input), is(output));
	}
	
	

}
