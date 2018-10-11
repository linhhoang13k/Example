/*
 * Author: Luisa McKenna
 * Problem By: CodeFights Level 5
 * 
 * Given an array of integers, find the maximal 
 * absolute difference between any two of its adjacent elements.
 */

public class MyArrayMaxAdjDifference {
	
	// arrayMaximalAdjacentDifference takes int array argument
	// and returns an int
	int arrayMaximalAdjacentDifference(int[] inputArray) {

	    int maximum = Math.abs(inputArray[1]- inputArray[0]);
	    int result = 0;
	    for(int i =1; i<inputArray.length-1; i++){
	        result =Math.abs(inputArray[i+1]- inputArray[i]);
	        if(result>=maximum){
	            maximum = result;
	        }
	    }
	    
	    return maximum;
	}
	
	// main tests arrayMaximalAdjacentDifference function
	public static void main(String args[]){
		MyArrayMaxAdjDifference a = new MyArrayMaxAdjDifference();
		System.out.println((a.arrayMaximalAdjacentDifference
				(new int[]{2,4,1,0})));
	}
}
