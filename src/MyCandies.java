/*
 * Author: Luisa McKenna
 * Problem By: CodeFights Core Level 1
 * 
 * n children have got m pieces of candy. 
 * They want to eat as much candy as they 
 * can, but each child must eat exactly 
 * the same amount of candy as any other child. 
 * 
 * Determine how many pieces of candy will be 
 * eaten by all the children together. Individual 
 * pieces of candy cannot be split.
 * 
 */

public class MyCandies {
	
	// candies function takes in a string 
	// as an input parameter and returns and boolean
	int candies(int n, int m) {
	    int div = m/n;
	    int result = n*div;
	    return result;
	}
	
	// main tests candies function
	public static void main(String args[]){
		MyCandies a = new MyCandies();
		System.out.println((a.candies(3,10)));
	}
}
