package Arcade;

/**
 * Solutions for Intro Gates in CODE-FIGHT
 * 
 * @author Christian Wang
 *
 */
public class IntroGates {

	/**
	 * You are given a two-digit integer n. Return the sum of its digits.
	 * 
	 * Example
	 * 
	 * For n = 29, the output should be
	 * 
	 * addTwoDigits(n) = 11.
	 * 
	 * Input/Output
	 * 
	 * [time limit] 3000ms (java) [input] integer n
	 * 
	 * A positive two-digit integer.
	 * 
	 * Constraints:
	 * 
	 * 10 ≤ n ≤ 99.
	 * 
	 * [output] integer
	 * 
	 * The sum of the first and second digits of the input number.
	 * 
	 * @param n
	 * @return
	 */
	public static int addTwoDigits(int n) {
		String digits = String.valueOf(n);
		return Integer.parseInt(String.valueOf(digits.charAt(0))) + Integer.parseInt(String.valueOf(digits.charAt(1)));
	}

	/**
	 * Given an integer n, return the largest number that contains exactly n
	 * digits.
	 * 
	 * Example
	 * 
	 * For n = 2, the output should be
	 * 
	 * largestNumber(n) = 99.
	 * 
	 * Input/Output
	 * 
	 * [time limit] 3000ms (java) [input] integer n
	 * 
	 * Constraints:
	 * 
	 * 1 ≤ n ≤ 7.
	 * 
	 * [output] integer
	 * 
	 * The largest integer of length n.
	 * 
	 * @param n
	 * @return
	 */
	public static int largestNumber(int n) {
		String sum = "";
		for (int i = 0; i < n; i++) {
			sum += "9";
		}
		return Integer.parseInt(sum);
	}

	/**
	 * n children have got m pieces of candy. They want to eat as much candy as
	 * they can, but each child must eat exactly the same amount of candy as any
	 * other child. Determine how many pieces of candy will be eaten by all the
	 * children together. Individual pieces of candy cannot be split.
	 * 
	 * Example
	 * 
	 * For n = 3 and m = 10, the output should be
	 * 
	 * candies(n, m) = 9.
	 * 
	 * Each child will eat 3 pieces. So the answer is 9.
	 * 
	 * Input/Output
	 * 
	 * [time limit] 3000ms (java) [input] integer n
	 * 
	 * The number of children.
	 * 
	 * Constraints:
	 * 
	 * 1 ≤ n ≤ 10.
	 * 
	 * [input] integer m
	 * 
	 * The number of pieces of candy.
	 * 
	 * Constraints:
	 * 
	 * 2 ≤ m ≤ 100.
	 * 
	 * [output] integer
	 * 
	 * The total number of pieces of candy the children will eat provided they
	 * eat as much as they can and all children eat the same amount.
	 * 
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	public static int candies(int n, int m) {
		if (m % n != 0) {
			return (m - (m % n));
		}
		return (m / n) * n;
	}

	/**
	 * Your friend advised you to see a new performance in the most popular
	 * theater in the city. He knows a lot about art and his advice is usually
	 * good, but not this time: the performance turned out to be awfully dull.
	 * It's so bad you want to sneak out, which is quite simple, especially
	 * since the exit is located right behind your row to the left. All you need
	 * to do is climb over your seat and make your way to the exit.
	 * 
	 * The main problem is your shyness: you're afraid that you'll end up
	 * blocking the view (even if only for a couple of seconds) of all the
	 * people who sit behind you and in your column or the columns to your left.
	 * To gain some courage, you decide to calculate the number of such people
	 * and see if you can possibly make it to the exit without disturbing too
	 * many people.
	 * 
	 * Given the total number of rows and columns in the theater (nRows and
	 * nCols, respectively), and the row and column you're sitting in, return
	 * the number of people who sit strictly behind you and in your column or to
	 * the left, assuming all seats are occupied.
	 * 
	 * Example
	 * 
	 * For nCols = 16, nRows = 11, col = 5 and row = 3, the output should be
	 * 
	 * seatsInTheater(nCols, nRows, col, row) = 96.
	 * 
	 * Here is what the theater looks like:
	 * 
	 * 
	 * 
	 * Input/Output
	 * 
	 * [time limit] 3000ms (java) [input] integer nCols
	 * 
	 * An integer, the number of theater's columns.
	 * 
	 * Constraints:
	 * 
	 * 1 ≤ nCols ≤ 1000.
	 * 
	 * [input] integer nRows
	 * 
	 * An integer, the number of theater's rows.
	 * 
	 * Constraints:
	 * 
	 * 1 ≤ nRows ≤ 1000.
	 * 
	 * [input] integer col
	 * 
	 * An integer, the column number of your own seat (1-based).
	 * 
	 * Constraints:
	 * 
	 * 1 ≤ col ≤ nCols.
	 * 
	 * [input] integer row
	 * 
	 * An integer, the row number of your own seat (1-based).
	 * 
	 * Constraints:
	 * 
	 * 1 ≤ row ≤ nRows.
	 * 
	 * [output] integer
	 * 
	 * The number of people who sit strictly behind you and in your column or to
	 * the left.
	 * 
	 * @param nCols
	 * @param nRows
	 * @param col
	 * @param row
	 * @return
	 */
	public static int seatsInTheater(int nCols, int nRows, int col, int row) {
		return (nCols - col + 1) * (nRows - row);
	}

	/**
	 * Given a divisor and a bound, find the largest integer N such that:
	 * 
	 * N is divisible by divisor. N is less than or equal to bound. N is greater
	 * than 0. It is guaranteed that such a number exists.
	 * 
	 * Example
	 * 
	 * For divisor = 3 and bound = 10, the output should be
	 * 
	 * maxMultiple(divisor, bound) = 9.
	 * 
	 * The largest integer divisible by 3 and not larger than 10 is 9.
	 * 
	 * Input/Output
	 * 
	 * [time limit] 3000ms (java) [input] integer divisor
	 * 
	 * Constraints:
	 * 
	 * 2 ≤ divisor ≤ 10.
	 * 
	 * [input] integer bound
	 * 
	 * Constraints:
	 * 
	 * 5 ≤ bound ≤ 100.
	 * 
	 * [output] integer
	 * 
	 * The largest integer not greater than bound that is divisible by divisor.
	 * 
	 * @param divisor
	 * @param bound
	 * @return
	 */
	public static int maxMultiple(int divisor, int bound) {
		int multiple = 0;
		for (int i = 0; i <= bound; i += divisor) {
			multiple = i;
		}
		return multiple;
	}

	/**
	 * Consider integer numbers from 0 to n - 1 written down along the circle in
	 * such a way that the distance between any two neighbouring numbers is
	 * equal (note that 0 and n - 1 are neighbouring, too).
	 * 
	 * Given n and firstNumber, find the number which is written in the radially
	 * opposite position to firstNumber.
	 * 
	 * Example
	 * 
	 * For n = 10 and firstNumber = 2, the output should be
	 * 
	 * circleOfNumbers(n, firstNumber) = 7.
	 * 
	 * 
	 * 
	 * Input/Output
	 * 
	 * [time limit] 3000ms (java) [input] integer n
	 * 
	 * A positive even integer.
	 * 
	 * Constraints:
	 * 
	 * 4 ≤ n ≤ 20.
	 * 
	 * [input] integer firstNumber
	 * 
	 * Constraints:
	 * 
	 * 0 ≤ firstNumber ≤ n - 1.
	 * 
	 * [output] integer
	 * 
	 * 
	 * @param n
	 * @param firstNumber
	 * @return
	 */
	public static int circleOfNumbers(int n, int firstNumber) {
		return (firstNumber >= n / 2) ? firstNumber - n / 2 : firstNumber + n / 2;
	}

	/**
	 * One night you go for a ride on your motorcycle. At 00:00 you start your
	 * engine, and the built-in timer automatically begins counting the length
	 * of your ride, in minutes. Off you go to explore the neighborhood.
	 * 
	 * When you finally decide to head back, you realize there's a chance the
	 * bridges on your route home are up, leaving you stranded! Unfortunately,
	 * you don't have your watch on you and don't know what time it is. All you
	 * know thanks to the bike's timer is that n minutes have passed since
	 * 00:00.
	 * 
	 * Using the bike's timer, calculate the current time. Return an answer as
	 * the sum of digits that the digital timer in the format hh:mm would show.
	 * 
	 * Example
	 * 
	 * For n = 240, the output should be
	 * 
	 * lateRide(n) = 4.
	 * 
	 * Since 240 minutes have passed, the current time is 04:00. The digits sum
	 * up to 0 + 4 + 0 + 0 = 4, which is the answer.
	 * 
	 * For n = 808, the output should be
	 * 
	 * lateRide(n) = 14.
	 * 
	 * 808 minutes mean that it's 13:28 now, so the answer should be 1 + 3 + 2 +
	 * 8 = 14.
	 * 
	 * Input/Output
	 * 
	 * [time limit] 3000ms (java) [input] integer n
	 * 
	 * The duration of your ride, in minutes. It is guaranteed that you've been
	 * riding for less than a day (24 hours).
	 * 
	 * Constraints:
	 * 
	 * 0 ≤ n < 60 · 24.
	 * 
	 * [output] integer
	 * 
	 * The sum of the digits the digital timer would show.
	 * 
	 * @param n
	 * @return
	 */
	public static int lateRide(int n) {
		int hrs = n / 60;
		int min = (n % 60);
		int sum = 0;

		System.out.println(hrs + ":" + min);

		for (int i = 0; i < String.valueOf(hrs).length(); i++) {
			sum += Integer.parseInt(String.valueOf(String.valueOf(hrs).charAt(i)));
		}

		for (int i = 0; i < String.valueOf(min).length(); i++) {
			sum += Integer.parseInt(String.valueOf(String.valueOf(min).charAt(i)));
		}

		return sum;
	}

	/**
	 * Some phone usage rate may be described as follows:
	 * 
	 * first minute of a call costs min1 cents, each minute from the 2nd up to
	 * 10th (inclusive) costs min2_10 cents each minute after 10th costs min11
	 * cents. You have s cents on your account before the call. What is the
	 * duration of the longest call (in minutes rounded down to the nearest
	 * integer) you can have?
	 * 
	 * Example
	 * 
	 * For min1 = 3, min2_10 = 1, min11 = 2 and s = 20, the output should be
	 * 
	 * phoneCall(min1, min2_10, min11, s) = 14.
	 * 
	 * Here's why:
	 * 
	 * the first minute costs 3 cents, which leaves you with 20 - 3 = 17 cents;
	 * the total cost of minutes 2 through 10 is 1 * 9 = 9, so you can talk 9
	 * more minutes and still have 17 - 9 = 8 cents; each next minute costs 2
	 * cents, which means that you can talk 8 / 2 = 4 more minutes. Thus, the
	 * longest call you can make is 1 + 9 + 4 = 14 minutes long.
	 * 
	 * Input/Output
	 * 
	 * [time limit] 3000ms (java) [input] integer min1
	 * 
	 * Constraints:
	 * 
	 * 1 ≤ min1 ≤ 10.
	 * 
	 * [input] integer min2_10
	 * 
	 * Constraints:
	 * 
	 * 1 ≤ min2_10 ≤ 10.
	 * 
	 * [input] integer min11
	 * 
	 * Constraints:
	 * 
	 * 1 ≤ min11 ≤ 10.
	 * 
	 * [input] integer s
	 * 
	 * Constraints:
	 * 
	 * 2 ≤ s ≤ 60.
	 * 
	 * [output] integer
	 * 
	 * @param min1
	 * @param min2_10
	 * @param min11
	 * @param s
	 * @return
	 */
	public static int phoneCall(int min1, int min2_10, int min11, int s) {
		int cents = s;
		int min = 0;
		cents -= min1;
		min++;
		if (cents <= 0)
			return min;

		for (int i = 0; i < 9; i++) {
			if (cents <= 0)
				return min - 1;
			cents -= min2_10;
			min++;

		}

		while (cents >= 0) {
			cents -= min11;
			min++;
		}
		return min - 1;
	}
}
