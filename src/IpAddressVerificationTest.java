package exercise21;

import org.junit.Assert;
import org.junit.Test;

public class IpAddressVerificationTest {

	@Test
	public void shouldReturnTrue() {
		IpAddressVerification underTest = new IpAddressVerification();
		String input = "172.16.254.1";
		boolean response = underTest.isIPv4Address(input);
		Assert.assertEquals(true, response);
	}
	
	@Test
	public void invalidInputShouldReturnFalse() {
		IpAddressVerification underTest = new IpAddressVerification();
		String input = "1702.16.254.1";
		boolean response = underTest.isIPv4Address(input);
		Assert.assertEquals(false, response);
	}
	
	@Test
	public void noFirstNumberInputShouldReturnFalse() {
		IpAddressVerification underTest = new IpAddressVerification();
		String input = ".16.254.1";
		boolean response = underTest.isIPv4Address(input);
		Assert.assertEquals(false, response);
	}
	
	@Test
	public void letterInputShouldReturnFalse() {
		IpAddressVerification underTest = new IpAddressVerification();
		String input = "a.16.c254.1";
		boolean response = underTest.isIPv4Address(input);
		Assert.assertEquals(false, response);
	}
}
