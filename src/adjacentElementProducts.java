int adjacentElementsProduct(int[] inputArray) {
    int curLarge = inputArray[0]*inputArray[1]; 
    for(int x = 0; x<inputArray.length - 1; x++){
        if ((inputArray[x]*inputArray[x+1]) > curLarge){
            curLarge = inputArray[x]*inputArray[x+1];
            System.out.println(curLarge);
        }
    }
    
    return curLarge;
}
