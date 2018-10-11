package exercise5;

public class Divisor {

	public int maxMultiple(int divisor, int bound) {
		int remainder = bound % divisor;
		return bound - remainder;
	}

}
