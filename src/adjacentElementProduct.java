int adjacentElementsProduct(int[] inputArray) {
    int maxProd = Integer.MIN_VALUE;
    
    for (int i=0;i<inputArray.length-1;i++) {
        maxProd = Math.max(inputArray[i]*inputArray[i+1], maxProd);
    }
    
    return maxProd;
}
