package exercise3;

public class CandyDistribution {

	public int candies(int children, int candies) {
		int equalCandies = candies;
		while (equalCandies % children != 0) {
			equalCandies--;
		}
		return equalCandies;
	}

}
