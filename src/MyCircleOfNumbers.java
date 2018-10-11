/*
 * Author: Luisa McKenna
 * Problem By: CodeFights Core Level 1
 * 
 * Consider integer numbers from 0 to n - 1 
 * written down along the circle in such a 
 * way that the distance between any two neighbouring 
 * numbers is equal (note that 0 and n - 1 are neighbouring, too).
 * 
 * Given n and firstNumber, find the number which is written in the 
 * radially opposite position to firstNumber.
 */
public class MyCircleOfNumbers {
	
	// circleOfNumbers function takes in two ints 
	// and returns int
	int circleOfNumbers(int n, int firstNumber) {
	    int result = 0;
	    if (firstNumber>n/2) {
	        result = firstNumber-n/2;
	    } else if (firstNumber==n/2) {
	        result = 0;
	    } else {
	        result = firstNumber+n/2;
	    }
	    return result;
	}
	
	// main tests circleOfNumbers function
	public static void main(String args[]){
		MyCircleOfNumbers a = new MyCircleOfNumbers();
		System.out.println((a.circleOfNumbers(10,2)));
	}
}
