package exercise39;

public class TreasureValueCalculator {

	/**
	 * You found two items in a treasure chest! The first item weighs weight1 and is
	 * worth value1, and the second item weighs weight2 and is worth value2. What is
	 * the total maximum value of the items you can take with you, assuming that
	 * your max weight capacity is maxW and you can't come back for the items later?
	 * 
	 * Note that there are only two items and you can't bring more than one item of
	 * each type, i.e. you can't take two first items or two second items.
	 * 
	 */
	
	public int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {
		int combinedWeight = weight1 + weight2;
		int combinedValue = value1 + value2;
		int possibleCount = 0;
		int maxValue = 0;
		if (weight1 <= maxW) {
			maxValue = value1;
			possibleCount++;
		}
		if (weight2 <= maxW) {
			maxValue = value2;
			possibleCount++;
		}
		if (combinedWeight > maxW && possibleCount == 2) {
			maxValue = findGreatestValue(value1, value2);
		}
		if (combinedWeight <= maxW) {
			maxValue = combinedValue;
		}
		
		return maxValue;
	}

	public int findGreatestValue(int value1, int value2) {
		int greatestValue = value1;
		if (value2 > value1) {
			greatestValue = value2;
		}
		return greatestValue;
	}
}
