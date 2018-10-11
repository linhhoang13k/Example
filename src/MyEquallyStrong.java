/*
 * Author: Luisa McKenna
 * Problem By: CodeFights Level 5
 * 
 * Call two arms equally strong if the heaviest 
 * weights they each are able to lift are equal.
 * 
 * Call two people equally strong if their strongest 
 * arms are equally strong (the strongest arm can be both 
 * the right and the left), and so are their weakest arms.
 * 
 * Given your and your friend's arms' lifting capabilities 
 * find out if you two are equally strong.
 */
public class MyEquallyStrong {
	
	// areEquallyStrong function takes in four int as arguments
	// and returns a boolean
	boolean areEquallyStrong(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {

	    boolean equal = true;
	    
	    int yourstrong = yourLeft;
	    int friendstrong = friendsLeft;
	    if(yourLeft<=yourRight){
	        yourstrong =yourRight;
	    }
	    
	    if(friendsLeft<=friendsRight){
	        friendstrong =friendsRight;
	    }
	    
	    if(yourLeft+yourRight!=friendsLeft+friendsRight){
	        equal = false;
	    } else if (yourstrong!=friendstrong) {
	        equal = false;
	    }
	    
	    return equal;
	}
	
	// main tests areEquallyStrong() function
	public static void main(String args[]){
		MyEquallyStrong a = new MyEquallyStrong();
		System.out.println(a.areEquallyStrong(10,15,5,20));
	}
}
