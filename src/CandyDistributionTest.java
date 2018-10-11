package exercise3;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CandyDistributionTest {

	private CandyDistribution underTest;
	
	@Before
	public void setup() {
		underTest = new CandyDistribution();
	}
	
	@Test
	public void shouldReturn9From3And10TestCase1() {
		assertThat(underTest.candies(3, 10), is(9));
	}
	
	@Test
	public void shouldReturn2From1And2TestCase2() {
		assertThat(underTest.candies(1, 2), is(2));
	}
	
	@Test
	public void shouldReturn0WhenLessCandyThanChildrenTestCase3() {
		assertThat(underTest.candies(10,  5), is(0));
	}
	
	@Test
	public void shouldReturnUnchangedWhenChildrenEqualCandyTestCase4() {
		assertThat(underTest.candies(4,4), is(4));
	}
}
