package exercise23;

import org.junit.Assert;
import org.junit.Test;

public class ImageBlurTest {

	@Test 
	public void shouldReturn1() {
		ImageBlur underTest = new ImageBlur();
		int[][] image = {{1,1,1},{1,7,1},{1,1,1}};
		int[][] response = underTest.boxBlur(image);

	}
	
	
}
