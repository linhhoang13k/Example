
public class Library {
	public static boolean checkPalindrome(String inputString) {
	    int i = 0;
	    while(i < inputString.length()/2){
	        if(inputString.charAt(i) != inputString.charAt(inputString.length()- i - 1)){
	            return false;
	        }
	        i++;
	    }
	    return true;
	}
	public static int makeArrayConsecutive2(int[] statues) {
	    int[] sorted = new int[statues.length];
	    int min = 21;
	    for(int size : statues)
	        if(size < min)
	            min = size;
	    sorted[0] = min;
	    for(int j = 0; j < sorted.length - 1; j++){
	        int diff = 21;
	        for(int i = 0; i < statues.length; i++){
	            if(statues[i] - sorted[j] < diff && statues[i] - sorted[j] > 0){
	                sorted[j + 1] = statues[i];
	                diff = statues[i] - sorted[j];
	            }
	        }
	    }
	    int statuesNeeded = 0;
	    for(int i = 0; i < sorted.length - 1; i++){
	        statuesNeeded += sorted[i + 1] - sorted[i] - 1;
	    }
	    return statuesNeeded;
	}
}
