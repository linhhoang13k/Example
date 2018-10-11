package exercise56;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FactoringToolTest {

	private FactoringTool underTest;
	
	@Before
	public void setup() {
		underTest = new FactoringTool();
	}

	@Test
	public void shouldReturn26From12TestCase1() {
		assertThat(underTest.digitsProduct(12), is(26));
	}

	@Test
	public void shouldReturnNegative1From18TestCase2() {
		assertThat(underTest.digitsProduct(19), is(-1));
	}
	
	@Test
	public void shouldReturn2559From450TestCase3() {
		assertThat(underTest.digitsProduct(450), is(2559));
	}

	// codefights logic... 0 should return 10...
	@Test
	public void shouldReturn10From0TestCase4() {
		assertThat(underTest.digitsProduct(0), is(10));
	}
	
	// codefights logic... single digits should return themselves
	@Test
	public void shouldReturn1From1() {
		assertThat(underTest.digitsProduct(1), is(1));
	}

	@Test
	public void shouldReturn2From2() {
		assertThat(underTest.digitsProduct(2), is(2));
	}

	@Test
	public void shouldReturn9From9() {
		assertThat(underTest.digitsProduct(9), is(9));
	}
	
	// custom test cases
	@Test
	public void shouldReturnNegatve1From33() {
		assertThat(underTest.digitsProduct(33), is(-1));
	}
	
	@Test
	public void shouldReturn889From576() {
		assertThat(underTest.digitsProduct(576), is(889));
	}
}
