package codeFights.arcade;

public class exercise {

	public static int largestNumber(int n) {
		
	    String output = "";
	    
	    while(n > 0) {
	        output += "9";
	        n--;
	    }
	    
	    System.out.printf(output);
	    
	    return Integer.parseInt(output);
		
	}
	
	public static int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {
	    
		if(maxW >= weight1 + weight2) {
			return value1 + value2;
		} else if(value1 >= value2) {
			if(maxW >= weight1) {
				return value1;
			} else if(maxW >= weight2) {
				return value2;
			} else 
				return 0;
		} else {
			if(maxW >= weight2) {
				return value2;
			} else if(maxW >= weight1) {
				return value1;
			} else 
				return 0;
		}
			
	}

	public static int[] metroCard(int lastNumberOfDays) {
	    
	    int[] myArray;
	    
	    if(lastNumberOfDays == 28 || lastNumberOfDays == 30) {
	    	myArray = new int[]{31};
	    } else {
	    	myArray = new int[]{28, 30, 31};
	    }

	    return myArray;
	}
	
}
