package exercise4;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TheaterBlueprintTest {

	private TheaterBlueprint underTest;
	
	@Before
	public void setup() {
		underTest = new TheaterBlueprint();
	}
	
	@Test
	public void shouldReturn96TestCase1() {
		int nCols = 16;
		int nRows = 11;
		int col = 5;
		int row = 3;
		assertThat(underTest.seatsInTheatre(nCols,nRows, col, row), is(96));
	}

	@Test
	public void shouldReturn0TestCase2() {
		int nCols = 1;
		int nRows = 1;
		int col = 1;
		int row = 1;
		assertThat(underTest.seatsInTheatre(nCols,nRows, col, row), is(0));
	}
	
	public void shouldReturn18TestCase3() {
		int nCols = 13;
		int nRows = 16;
		int col = 8;
		int row = 3;
		assertThat(underTest.seatsInTheatre(nCols,nRows, col, row), is(18));
	}
}
