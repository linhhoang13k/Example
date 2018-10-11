package exercise30;

public class OppositeCircleReturner {

	public int circleOfNumbers(int n, int firstNumber) {

		/**
		 * Consider integer numbers from 0 to n - 1 written down along the
		 * circle in such a way that the distance between any two neighbouring
		 * numbers is equal (note that 0 and n - 1 are neighbouring, too).
		 * 
		 * Given n and firstNumber, find the number which is written in the
		 * radially opposite position to firstNumber.
		 */

		int degrees = 360;
		int separatedBy = degrees/n;
		
		int places = 180 / separatedBy;
		int across = firstNumber + places;
		if (across == n) {
			across = 0;
		} if (across > n) {
			across = across - n;
		}
		return across;
	}

}
