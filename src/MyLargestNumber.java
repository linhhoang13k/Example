/*
 * Author: Luisa McKenna
 * Problem By: CodeFights Core Level 1
 * 
 * Given an integer n, 
 * return the largest number that contains exactly n digits.
 */
public class MyLargestNumber {
	
	// largestNumber function takes int argument and returns
	// int
	int largestNumber(int n) {
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0; i< n; i++){
	        sb.append("9");
	    }
	    return Integer.parseInt(sb.toString());
	}
	
	// main tests largestNumber function
	public static void main(String args[]){
		MyLargestNumber a = new MyLargestNumber();
		System.out.println((a.largestNumber(2)));
	}
}
