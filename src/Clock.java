package exercise53;

import java.util.regex.Pattern;

public class Clock {

	public boolean isValidTime(String time) {
		String[] hourAndMin = time.split(":");
		int hour = Integer.parseInt((hourAndMin[0]));
		int min = Integer.parseInt(hourAndMin[1]);
		return hour >= 0 && hour <= 23 && min >= 0 && min <= 59;
	}

}
