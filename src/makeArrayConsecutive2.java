public class MakeArrayConsecutive2 
{
	int makeArrayConsecutive2(int[] statues) 
	{
	    ArrayList<Integer> aList = new ArrayList<Integer>();
	    int sum = 0;
	    
	    //Add array to aList
	    for(int i = 0; i < statues.length; i++)
	    {
	        aList.add(statues[i]);
	    }
	    
	    //Sort aList
	    Collections.sort(aList);
	    
	    //Find the difference between the element and the one next to it plus 1
	    for(int i = 0; i < aList.size() - 1; i++)
	    {
	        if(aList.get(i) + 1 < aList.get(i + 1))
	        {
	            sum += aList.get(i + 1) - (aList.get(i) + 1);
	        }
	    }
	    return sum;
	}
}
