package codefights.arcade;

public class MaxProductAdjacentElements {

	public static void main(String[] args) {

		int[] check = { 100, 0, 3, 9, 8, 7, 5 };

		System.out.println(adjacentElementsProduct(check));

	}

	public static int adjacentElementsProduct(int[] inputArray) {

		int maxProduct = Integer.MIN_VALUE;

		for (int i = 0; i < inputArray.length - 1; i++) {
			
		int	tempProduct  = inputArray[i] * inputArray[i + 1];
			
			if (tempProduct > maxProduct)

				maxProduct = tempProduct;

		}
		return maxProduct;
	}
}
