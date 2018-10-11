int adjacentElementsProduct(int[] inputArray) 
{
    int max=-1001,multiply=0;
    for(int i=0;i<inputArray.length-1;i++)
    {
        multiply=inputArray[i]*inputArray[i+1];
        if(max<multiply)
        {
            max=multiply;
        }
    }
    return max;
}