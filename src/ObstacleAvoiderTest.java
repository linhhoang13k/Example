package exercise22;

import org.junit.Assert;
import org.junit.Test;

public class ObstacleAvoiderTest {

	@Test
	public void shouldReturn3() {
		ObstacleAvoider underTest = new ObstacleAvoider();
		int[] inputArray = { 2, 3, 4, 8, 9 };
		int response = underTest.avoidObstacles(inputArray);
		Assert.assertEquals(5, response);
	}
	
	@Test
	public void unorderedShouldReturn3() {
		ObstacleAvoider underTest = new ObstacleAvoider();
		int[] inputArray = { 3, 2, 4, 8, 9 };
		int response = underTest.avoidObstacles(inputArray);
		Assert.assertEquals(5, response);
	}
	
	@Test
	public void multipleSpansShouldReturn4(){
		ObstacleAvoider underTest = new ObstacleAvoider();
		int[] inputArray = { 1, 2, 3, 8, 9, 11, 12 };
		int response = underTest.avoidObstacles(inputArray);
		Assert.assertEquals(5, response);
	}
	
}
