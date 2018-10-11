int adjacentElementsProduct(int[] inputArray) {
    int largestAdjacentPoduct = inputArray[0] * inputArray[1];
    for(int i = 1; i < inputArray.length - 1; i++) {
        int adjacentProduct = inputArray[i] * inputArray[i + 1];
        if(adjacentProduct > largestAdjacentPoduct)
            largestAdjacentPoduct = adjacentProduct;
    }
    return largestAdjacentPoduct;
}