/*
 * Author: Luisa McKenna
 * Problem By: CodeFights Level 2
 * 
 * Given an array of integers, find the pair of adjacent 
 * elements that has the largest product and return that product.
 * 
 */
public class MyAdjacentElementsProduct {

	public static int adjacentElementsProduct(int[] inputArray) {

	    int largest = inputArray[0]*inputArray[1];
	    for(int i = 1; i< inputArray.length-1; i++){
	        int newlarge =  inputArray[i]*inputArray[i+1];
	        if(newlarge>largest){
	            largest=newlarge;
	        }
	    }
	    return largest;
	}
	
	public static void main(String args[]){
		System.out.println(adjacentElementsProduct(new int[]{3,6,-2,-5,7,3}));
	}
}
