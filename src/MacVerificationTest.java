package exercise47;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MacVerificationTest {

	private MacVerification underTest;
	
	@Before
	public void setup() {
		underTest = new MacVerification();
	}
	
	@Test
	public void validMacAddressIsTrueTestCase1() {
		assertTrue(underTest.isMAC8Address("00-1B-63-84-45-E6"));
	}
	
	@Test
	public void invalidMacAddressWithZIsFalseTestCase2() {
		assertFalse(underTest.isMAC8Address("Z1-1B-63-84-45-E6"));
	}
	
	@Test
	public void stringEntryIsFalseTestCase3() {
		assertFalse(underTest.isMAC8Address("not a Mac-48 address"));
	}

	@Test
	public void macAddressAllFsIsTrueTestCase4() {
		assertTrue(underTest.isMAC8Address("FF-FF-FF-FF-FF-FF"));
	}

	@Test
	public void macAddressAll0sIsTrueTestCase5() {
		assertTrue(underTest.isMAC8Address("00-00-00-00-00-00"));
	}
	
	@Test
	public void macAddressWithGIsFalseTestCase6() { 
		assertFalse(underTest.isMAC8Address("G0-00-00-00-00-00"));
	}
	
	@Test
	public void macAddressWithTrailingHyphenIsFalseTestCase7() {
		assertFalse(underTest.isMAC8Address("02-03-04-05-06-07-"));
	}
	
	@Test
	public void macAddressWithAllValidCharsIsTrueTestCase8() {
		assertTrue(underTest.isMAC8Address("12-34-56-78-9A-BC"));
	}

}
