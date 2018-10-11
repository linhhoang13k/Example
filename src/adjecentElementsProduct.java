/*
Given an array of integers, find the pair of adjacent elements that has the largest product and return that product.

Example

For inputArray = [3, 6, -2, -5, 7, 3], the output should be
adjacentElementsProduct(inputArray) = 21.

7 and 3 produce the largest product.

Input/Output

    [time limit] 3000ms (java)

    [input] array.integer inputArray

    An array of integers containing at least two elements.

    Guaranteed constraints:
    2 ≤ inputArray.length ≤ 10,
    -1000 ≤ inputArray[i] ≤ 1000.

    [output] integer

    The largest product of adjacent elements.


*/
int adjacentElementsProduct(int[] inputArray) {
    int product = inputArray[0] * inputArray[1];
    
    for (int index = 0; index < inputArray.length - 1; index++)
    {
        if (inputArray[index] * inputArray[index + 1] > product)
        {
            product = inputArray[index] * inputArray[index + 1];
        }
    }
    return product;
}
