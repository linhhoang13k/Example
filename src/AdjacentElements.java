package arcadeintro.edgeoftheocean;

/*
For inputArray = [3, 6, -2, -5, 7, 3], the output should be
adjacentElementsProduct(inputArray) = 21.
7 and 3 produce the largest product.
 */
public class AdjacentElements {
    public static void main(String[] args) {
        int[] inputArray = {3, 6, -2, -5, 7, 3};
        System.out.println(highestproduct(inputArray));
    }

    private static int highestproduct(int[] inputArray) {
        int maxProduct = inputArray[0] * inputArray[1];
        for (int i = 1; i < inputArray.length - 1; i++) {
            if (maxProduct < inputArray[i] * inputArray[i + 1])
                maxProduct = inputArray[i] * inputArray[i + 1];
        }
        return maxProduct;
    }
}
