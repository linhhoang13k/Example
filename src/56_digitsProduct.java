/*
Given an integer product, find the smallest positive (i.e. greater than 0) integer the product of whose digits is equal to product. If there is no such integer, return -1 instead.

Example

    For product = 12, the output should be
    digitsProduct(product) = 26;
    For product = 19, the output should be
    digitsProduct(product) = -1.

Input/Output

    [execution time limit] 3 seconds (java)

    [input] integer product

    Guaranteed constraints:
    0 ≤ product ≤ 600.

    [output] integer
*/

// Brute force solution
int digitsProduct(int product) {
    int maxValue = 9999;
    int value = 0;
    //Try every number from 1 to max value (9999)
   for(int i = 0; i < maxValue+1; i++){
        value++;
        String valueString = Integer.toString(value);
        int length = valueString.length();
        int digitProduct = Character.getNumericValue(valueString.charAt(0));
        for(int digit = 1; digit < length; digit++){
            digitProduct *= Character.getNumericValue(valueString.charAt(digit));
        }
        if(digitProduct == product){
            break;
        }
        if(value == maxValue){
            value = -1;
            break;
        }
    }
    return value;
}
