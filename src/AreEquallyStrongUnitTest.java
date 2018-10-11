package island.of.knowledge;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AreEquallyStrongUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {
		int yourLeft = 10;
		int yourRight = 15;
		int friendsLeft = 15;
		int friendsRight = 10;
		boolean result = areEquallyStrong(yourLeft, yourRight, friendsLeft, friendsRight);

		assertTrue(result);
	}

	@Test
	public void test5() {
		int yourLeft = 10;
		int yourRight = 15;
		int friendsLeft = 5;
		int friendsRight = 20;
		boolean result = areEquallyStrong(yourLeft, yourRight, friendsLeft, friendsRight);

		assertFalse(result);
	}

	boolean areEquallyStrong(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {

		return (yourLeft + yourRight) == (friendsLeft + friendsRight)
				&& (yourLeft == friendsLeft || yourLeft == friendsRight);
	}

}
