package exercise27;

import org.junit.Assert;
import org.junit.Test;



public class VariableNameCheckerTest {

	@Test
	public void shouldReturnTrueFroma_b() {
		VariableNameChecker underTest = new VariableNameChecker();
		boolean response = underTest.variableName("a_b");
		Assert.assertEquals(true, response);
	}
	
	@Test
	public void shouldReturnFalseFrom1aa() {
		VariableNameChecker underTest = new VariableNameChecker();
		boolean response = underTest.variableName("1aa");
		Assert.assertEquals(false, response);
	}
	
	@Test
	public void shouldReturnTrueFroma1a() {
		VariableNameChecker underTest = new VariableNameChecker();
		boolean response = underTest.variableName("a1a");
		Assert.assertEquals(true, response);
	}
}
