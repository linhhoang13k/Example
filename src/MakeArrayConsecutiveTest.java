package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import main.MakeArrayConsecutive;

public class MakeArrayConsecutiveTest {

	@Test
	public void shouldReturn2ForNumberOfMissingStatues() {
		int[] statues = { 6, 5, 3, 9, 8 };
		int result = MakeArrayConsecutive.makeArrayConsecutive(statues);
		assertThat(result, is(2));
	}

}
