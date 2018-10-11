package exercise56;

import java.util.ArrayList;
import java.util.List;

public class FactoringTool {

	/*
	 * Given an integer product, find the smallest positive (i.e. greater than 0)
	 * integer the product of whose digits is equal to product. If there is no such
	 * integer, return -1 instead.
	 */
	private List<Integer> factors = new ArrayList<>();

	public int digitsProduct(int product) {
		StringBuffer smallestIntAnswer = new StringBuffer();
		getSingleDigitAnswer(product);
		
		if (product >= 10) {
			factors.clear();
			generateFactors(product);
		} 
		
		int checkAnswer = 1;
		
		for (int i = 0; i < factors.size(); i++) {
			smallestIntAnswer.append(factors.get(i));
			checkAnswer *= factors.get(i);
		}
	
		if (checkAnswer != product && product > 9) {
			smallestIntAnswer.replace(0, factors.size(), "-1");
		}
		
		return Integer.parseInt(smallestIntAnswer.toString());
	}

	private void generateFactors(int product) {
		for (int factor = 9; factor >= 2; factor--) {
			while (product % factor == 0) {
				factors.add(0, factor);
				product = product / factor;
			}
		}
	}
	
	private void getSingleDigitAnswer(int temp) {
		// handles codefights logic edge cases 
		if (temp == 0) {
			factors.add(10);
		} else {
			factors.add(temp);
		}
	}
	
}
