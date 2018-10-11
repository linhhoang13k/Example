
public class findObstacles 
{
	public static void main(String v[])
	{
		int[] arr = {1, 4, 10, 6, 2};
		System.out.println(avoidObstacles(arr));
	}
	static int avoidObstacles(int[] inputArray) 
	{
	    int step = 1;
	    int j=0;
	    int max = 0;
	    for(int i=0; i<inputArray.length; i++)
	    {
	    	if(inputArray[i]>max)
	    		max = inputArray[i];
	    }
	    while(j!=max)
	    {
	        boolean found = true;
	        for(int i=0; i<inputArray.length; i++)
	        {
	            if(inputArray[i]%step ==0)
	            {    
	                found = false;
	                break;
	            }
	        }
	        j++;
	        if(found == true)
	            return step; 
	        step++;
	       
	    }
	    return step;
	    
	}

}
