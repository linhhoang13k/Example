import java.util.*;

public class FirstDuplicateElement 
{
	public static void main(String[] args) 
	{
    	  int n = 2;
    	  int arr[] = {2, 2};
          int result = findDuplicate(arr, n);
          System.out.println(" "+ result +" ");
	}
	
	// function to find the duplicate element in array 
	
	public static int findDuplicate(int arr[], int n)
	{
		Map<Integer, Integer> second = new HashMap<>();
		Set<Integer> first = new HashSet<>();
		for(int i=0; i<n; i++) {
		 
		  int num = arr[i];
		  if(first.contains(num) && !second.containsKey(num))
			  second.put(num , i);  // adding the element which is not in the index 
		  first.add(num);
		}
		
		int selected = -1;
		int minIndex = 	arr.length;
		for(Map.Entry<Integer,Integer> entry : second.entrySet())
		{ 
			if(entry.getValue() < minIndex)
			{
				minIndex = entry.getValue();
				selected = entry.getKey();
			}
		}
		return selected;
	}

}
