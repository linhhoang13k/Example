package exercise19;

import org.junit.Assert;
import org.junit.Test;

public class EqualStrengthTest {

	@Test
	public void identicalEntriesShouldReturnTrue() {
		EqualStrength underTest = new EqualStrength();
		int yourLeft = 10;
		int yourRight = 10;
		int friendsLeft = 10;
		int friendsRight = 10;
		boolean response = underTest.areEquallyStrong(yourLeft, yourRight, friendsLeft, friendsRight);
		Assert.assertEquals(true, response);
	}
	
	@Test
	public void reverseEntriesShouldReturnTrue() {
		EqualStrength underTest = new EqualStrength();
		int yourLeft = 15;
		int yourRight = 10;
		int friendsLeft = 10;
		int friendsRight = 15;
		boolean response = underTest.areEquallyStrong(yourLeft, yourRight, friendsLeft, friendsRight);
		Assert.assertEquals(true, response);
	}
	
	@Test
	public void identicalEntriesForEachFriendShouldReturnFalse() {
		EqualStrength underTest = new EqualStrength();
		int yourLeft = 15;
		int yourRight = 15;
		int friendsLeft = 10;
		int friendsRight = 10;
		boolean response = underTest.areEquallyStrong(yourLeft, yourRight, friendsLeft, friendsRight);
		Assert.assertEquals(false, response);
	}
	
	@Test
	public void unequalEntriesShouldReturnFalse() {
		EqualStrength underTest = new EqualStrength();
		int yourLeft = 15;
		int yourRight = 10;
		int friendsLeft = 9;
		int friendsRight = 15;
		boolean response = underTest.areEquallyStrong(yourLeft, yourRight, friendsLeft, friendsRight);
		Assert.assertEquals(false, response);
	}
}
