package test;

public class AllLongestStrings {
	
	String[] allLongestStrings(String[] inputArray) {
	    
	    int max  = 0;
	    
	    String[] finalStringArray = new String[inputArray.length];
	    
	    for (int i=0;i<inputArray.length;i++)
	    {
	        if (max < inputArray[i].length())
	            
	            max = inputArray[i].length();
	    }
	    int finalCount = 0;
	    for (int i=0;i<inputArray.length;i++)
	    {
	        if (max == inputArray[i].length())
	        {
	        finalStringArray[finalCount] =   inputArray[i];
	        finalCount++;
	        }
	    }
	    
	    return finalStringArray;

	}
	
	public static void main(String args[])
	{
		AllLongestStrings all = new AllLongestStrings();
		
		String[] inputArray = {"aba", "aa", "ad", "vcd", "aba"};
		
		String[] finalSting = all.allLongestStrings(inputArray);
		
		for (int i=0;i<finalSting.length;i++)
		{
			System.out.println(finalSting[i]);
		}
	}

}
