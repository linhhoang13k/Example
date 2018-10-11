package exercise47;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MacVerification {

	public static List<Character> validChars = new ArrayList<>();
	
	public boolean isMAC8Address(String inputString) {
		return Pattern.matches("([0-9a-fA-F]{2}[-]){5}([0-9a-fA-F]{2})", inputString);
	}
	
}
