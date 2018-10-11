/*
 * Author: Luisa McKenna
 * Problem By: CodeFights Level 3
 * 
 * Ticket numbers usually consist of even number of digits.
 * A ticket number is considered lucky if the sum of the first half
 * of the digits is equal to the sum of the second half.
 * 
 * Given a ticket number, n, determine if it is luck or not.
 * 
 */
public class MyIsLucky {

	public static boolean isLucky(int n) {

	    boolean lucky = true;
	    int firsthalf = 0;
	    int secondhalf = 0;
	    String a = Integer.toString(n); 
	    int[] arr = new int[a.length()];
	    
	    //integer values into array
	    for(int i = 0; i<a.length(); i++){
	        arr[i] = Character.getNumericValue(a.charAt(i));
	    }
	    
	    //add up first half and second half
	    for(int j = 0; j<a.length(); j++){
	        if(a.length()/2>j){
	            firsthalf+=arr[j];
	        }
	        else{
	            secondhalf+=arr[j];
	        }
	    }
	    
	    if(firsthalf!=secondhalf){
	        lucky = false;
	    }
	    return lucky;
	}
	
	public static void main(String args[]){
		System.out.println(isLucky(1230));
	}
}
