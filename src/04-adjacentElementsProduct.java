int adjacentElementsProduct(int[] inputArray) {

    int product = inputArray[0]*inputArray[1];
   
    for (int i = 0; i+1< inputArray.length; i++){
        int max = inputArray[i]*inputArray[i+1];
        if (max > product)
        {
            product = max;
        }
       
    }
    return product;

}
