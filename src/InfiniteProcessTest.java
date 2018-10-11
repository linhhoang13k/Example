package exercise9;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class InfiniteProcessTest {

	private InfiniteProcess underTest;
	
	@Before
	public void setup() {
		underTest = new InfiniteProcess();
	}
	
	@Test
	public void shouldReturnFalseForA2AndB6() {
		int a = 2;
		int b = 6;
		assertFalse(underTest.isInfiniteProcess(a,b));
	}
	
	@Test
	public void shouldReturnTrueForA2AndB3() {
		assertTrue(underTest.isInfiniteProcess(2, 3));
	}
}
