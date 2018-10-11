int adjacentElementsProduct(int[] inputArray) {
    int max = Integer.MIN_VALUE;
    for(int i = inputArray.length - 1; i > 0; i--){
        int current = inputArray[i]*inputArray[i-1];
        if(current > max){
            max = current;
        }
        
    }
    return max;
}