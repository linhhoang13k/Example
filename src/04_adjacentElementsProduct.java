/*
Given an array of integers, find the pair of adjacent elements 
that had the largest product and return that product.
Guaranteed contraints: 
2<=inputArray.length <=10
-1000<= inputArray[i] <=1000
*/

int adjacentElementsProduct(int[] inputArray) {
    int arrayLength = inputArray.length;
    int newArray[] = inputArray.clone();
    int maxProduct = -1001;
    int product = 0;
        
    //loop through pairs , find the max
    for(int element = 0; element < arrayLength - 1; element++){
        product = newArray[element] * newArray[element + 1];
        if (product > maxProduct){
            maxProduct = product;
        }
    }
    return maxProduct;
}
