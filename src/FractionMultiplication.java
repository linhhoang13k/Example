package codeFight;

import java.math.BigInteger;

public class FractionMultiplication {

	int[] fractionMultiplication(int[] a, int[] b) {
	    int x= a[0]*b[0];
	    int y =a[1]*b[1];
	    BigInteger p =BigInteger.valueOf(x);
	        BigInteger q =BigInteger.valueOf(y);
	    BigInteger b3 =p.gcd(q);
	    int s =b3.intValue();
	    x= x/s;
	    y=y/s;
	    return new int [] {x,y};
	    
	        
	    
	}
	static int gcd(int a ,int b)
	    {
	        if(a==0)
	            return b;
	        return gcd(a%b,b);
	    }
}
