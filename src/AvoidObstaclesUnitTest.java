package island.of.knowledge;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class AvoidObstaclesUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {
		int[] inputArray = { 5, 3, 6, 7, 9 };

		int result = avoidObstacles(inputArray);

		assertTrue(result == 4);
	}

	@Test
	public void test3() {
		int[] inputArray = { 1, 4, 10, 6, 2 };

		int result = avoidObstacles(inputArray);

		assertTrue(result == 7);
	}

	int avoidObstacles(int[] inputArray) {

		Arrays.sort(inputArray);
		int[] obstacles = new int[41];

		for (int i = 0; i < inputArray.length; i++) {
			obstacles[inputArray[i]] = inputArray[i];
		}

		int jumpEnough = 0;
		int maxObstacle = inputArray[inputArray.length - 1];
		boolean isJumpOk = false;

		while (jumpEnough < maxObstacle && !isJumpOk) {
			jumpEnough = calculateJump(obstacles, jumpEnough);

			isJumpOk = jumpOk(jumpEnough, obstacles);
		}


		return jumpEnough;
	}

	int calculateJump(int[] obstacles, int lastJump) {
		int nextJump = lastJump + 1;

		while (obstacles[nextJump] > 0)
			nextJump++;

		return nextJump;
	}

	boolean jumpOk(int jumpEnough, int[] obstacles) {

		for (int j = 0; j < obstacles.length; j = j + jumpEnough) {
			if (obstacles[j] > 0)
				return false;
		}

		return true;
	}

}
