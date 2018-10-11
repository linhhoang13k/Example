/*
 * Author: Luisa McKenna
 * Problem By: CodeFights Core Level 1
 * 
 * Given a divisor and a bound, find the largest integer N such that:
 * N is divisible by divisor.
 * N is less than or equal to bound.
 * N is greater than 0.
 * It is guaranteed that such a number exists. 
 */
public class MyMaxMultiple {
	
	// maxMultiple function takes in a string 
	// as an input parameter and returns and boolean
	int maxMultiple(int divisor, int bound) {
	    int result = 0;
	    for(int i = divisor + 1; i<=bound; i++){
	        if(i%divisor==0){
	            if(i>result){
	               result = i;
	            }
	        }
	    }
	    return result;
	}
	
	// main tests maxMultiple function
	public static void main(String args[]){
		MyMaxMultiple a = new MyMaxMultiple();
		System.out.println((a.maxMultiple(3,10)));
	}
}
