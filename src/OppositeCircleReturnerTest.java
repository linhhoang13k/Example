package exercise30;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OppositeCircleReturnerTest {

	@Test
	public void shouldReturn7() {
		OppositeCircleReturner underTest = new OppositeCircleReturner(); 
		int response = underTest.circleOfNumbers(10, 2);
		assertEquals(7, response);
	}
	
	@Test
	public void shouldReturn0() {
		OppositeCircleReturner underTest = new OppositeCircleReturner(); 
		int response = underTest.circleOfNumbers(6, 3);
		assertEquals(0, response);
	}
	
	@Test
	public void shouldReturn3() {
		OppositeCircleReturner underTest = new OppositeCircleReturner(); 
		int response = underTest.circleOfNumbers(4, 1);
		assertEquals(3, response);
	}
	
	@Test
	public void shouldReturn2() {
		OppositeCircleReturner underTest = new OppositeCircleReturner(); 
		int response = underTest.circleOfNumbers(10, 7);
		assertEquals(2, response);
	}
}
