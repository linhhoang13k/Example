package exercise7;

public class RideClock {

	public int lateRide(int n) {
		int hour = n / 60;
		int minute = n % 60;
		int firstHour = hour / 10;
		int secondHour = hour % 10;
		int firstMinute = minute / 10;
		int secondMinute = minute % 10;
		return firstHour + secondHour + firstMinute + secondMinute;
	}

}
