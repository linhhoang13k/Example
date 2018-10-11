package exercise46;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ElectionProjectionTest {

	private ElectionProjection underTest;

	@Before
	public void setup() {
		underTest = new ElectionProjection();
	}

	@Test
	public void shouldReturn2PossibleWinnersTestCase1() {
		int[] votes = { 2, 3, 5, 2 };
		assertThat(underTest.electionsWinners(votes, 3), is(2));
	}

	@Test
	public void shouldReturn0PossibleWinnersTestCase2() {
		int[] votes = { 1, 3, 3, 1, 1 };
		assertThat(underTest.electionsWinners(votes, 0), is(0));
	}

	@Test
	public void shouldReturn1PossibleWinnersTestCase3() {
		int[] votes = { 5, 1, 4, 3, 1 };
		assertThat(underTest.electionsWinners(votes, 0), is(1));
	}

	@Test
	public void shouldReturn4PossibleWinnersTestCase4() {
		int[] votes = { 1, 1, 1, 1 };
		assertThat(underTest.electionsWinners(votes, 1), is(4));
	}

	@Test
	public void shouldReturn0PossibleWinnersTestCase5() {
		int[] votes = { 1, 1, 1, 1 };
		assertThat(underTest.electionsWinners(votes, 0), is(0));
	}

	@Test
	public void shouldReturn2PossibleWinnersTestCase6() {
		int[] votes = { 3, 1, 1, 3, 1 };
		assertThat(underTest.electionsWinners(votes, 2), is(2));
	}
}
