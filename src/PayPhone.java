package exercise8;

public class PayPhone {

	/*
	 * Some phone usage rate may be described as follows:
	 * 
	 * first minute of a call costs min1 cents, each minute from the 2nd up to 10th
	 * (inclusive) costs min2_10 cents each minute after 10th costs min11 cents. You
	 * have s cents on your account before the call. What is the duration of the
	 * longest call (in minutes rounded down to the nearest integer) you can have?
	 */

	public int phoneCall(int min1, int min2_10, int min11, int s) {
		int subtract = min1;
		int currentMin = 0;
		while (s >= subtract) {
			if (currentMin == 1) {
				subtract = min2_10;
			}
			if (currentMin == 10) {
				subtract = min11;
			}
			s -= subtract;
			currentMin++;
		}
		return currentMin;
	}

}
