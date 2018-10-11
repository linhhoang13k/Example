/*
 * Author: Luisa McKenna
 * Problem By: CodeFights Core Level 1
 * 
 * You are given a two-digit integer n. 
 * Return the sum of its digits.
 */
import java.util.LinkedList;

public class MyAddTwoDigits {
	
	// addTwoDigits function takes int a as argument 
	// and returns int
	int addTwoDigits(int n) {
		LinkedList<Integer> stack = new LinkedList<Integer>();
		    int addTwo = 0;
		    while (n > 0) {
		        stack.push( n % 10 );
		        n = n / 10;
		    }

		    while (!stack.isEmpty()) {
		        addTwo+=stack.pop();
		    }
		    
		    return addTwo;
		}
	
	// main tests addTwoDigits() function
	public static void main(String args[]){
		MyAddTwoDigits a = new MyAddTwoDigits();
		System.out.println((a.addTwoDigits(29)));
	}

}
