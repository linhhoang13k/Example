/*
 * Author: Luisa McKenna
 * Problem By: CodeFights Level 4
 * 
 * You are given an array of integers. On each move you are allowed
 * to increase exactly one of its element by one. Find the minimal number
 * of moves required to obtain a strictly increasing sequence from the input.
 * 
 */
public class MyArrayChange {
	
	public static int arrayChange(int[] inputArray) {
	    
	    int countMoves = 0;
	    int result = 0;
	    
	    //loop array if the index before is less increase the index until its greater and count increases
	    for(int i = 1; i<inputArray.length; i++){
	        if(inputArray[i-1]>=inputArray[i]){
	            result = Math.abs(inputArray[i-1]-inputArray[i]);
	            for(int j = 0;j<result+1; j++){
	                inputArray[i]++;
	                countMoves++;
	            }
	        }
	    }
	    return countMoves;
	}
	
	public static void main(String args[]){
		System.out.println(arrayChange(new int[]{1,1,1}));
	}
}
