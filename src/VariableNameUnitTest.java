package rains.of.reason;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class VariableNameUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {
		String name = "var_1__Int";

		boolean result = variableName(name);

		assertTrue(result);
	}

	boolean variableName(String name) {

		return name.matches("([A-Z]|[a-z]|_){1}\\w*");
	}
}
