int adjacentElementsProduct(int[] inputArray) {
    int product = -1000;
    int length = inputArray.length;
    
    for (int i = 0; i < (length - 1); i++) {
        if (product < (inputArray[i] * inputArray[i + 1])) {
            product = (inputArray[i] * inputArray[i + 1]);
        }
    }
    
    return product;
}
