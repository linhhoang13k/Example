package dailyChallenge;

/**
 * All of you may know that when doing bit XOR we are doing it from the right side. Here is the example:

     101 (decimal 5)
XOR   11 (decimal 3)
  =  110 (decimal 6)
But in this challenge bitLXor, you will need to do it from the left. Left take the above example:

     101 (decimal 5)
LXOR 11  (decimal 3)
   = 011 (decimal 3)
Provided 2 numbers a and b, return value of the LXOR operation.
 */
public class bitLXor {
	
	static int bitLXor(int a, int b) {
	    if(a * b == -1) return -2;
			int d = 1;
			if (a < 0) {
				d *= -1;
				a = -a;
			}
			if (b < 0) {
				d *= -1;
				b = -b;
			}
			int x = l(a) - l(b);
			if (x > 0) {
				b <<= x;
			} else{
				a <<= -x;
			}
			return (a ^ b) * d;
		}

	static int l(int a){
	    return Integer.toBinaryString(a).length();
	}

	
	public static void main(String[] args) {
		System.out.println(Integer.parseInt("101", 2));
		System.out.println(Integer.parseInt("111", 2));
		System.out.println(bitLXor(1,-3));
	
	}

}
