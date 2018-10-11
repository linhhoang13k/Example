package codeFights.challenges;

public class challenges {

	public static int rangeXOR(int a, int b) {
	    int sum = a;
	    while(a < b) {
	    	a++;
	        sum ^= a;
	    }
	    return sum;
	}
	
}
