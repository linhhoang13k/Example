
public class AdjacentElementsProduct 
{
	int adjacentElementsProduct(int[] inputArray) 
	{
	    int max = inputArray[0]*inputArray[1];
	    for(int i = 1; i < inputArray.length - 1; i++)
	    {
	        if(inputArray[i] * inputArray[i+1] > max)
	        {
	            max = inputArray[i]*inputArray[i+1];
	        }
	    }
	    return max;
	}
}
