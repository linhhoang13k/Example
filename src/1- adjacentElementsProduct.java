int adjacentElementsProduct(int[] inputArray) {
int size = inputArray.length;
    int temp = inputArray[0] * inputArray[1];
    for(int i = 1 ; i < size -1 ; i ++){
        if ( temp  < inputArray[i] * inputArray[i+1]){
            temp = inputArray[i] * inputArray[i+1];
         }
    }
    return temp;
}
