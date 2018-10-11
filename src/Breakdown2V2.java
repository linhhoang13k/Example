package com.codefight.challanges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * @author muralimanohar
 * Given an array of strings, output the following:
 * An array of various whole, positive numbers, as defined in the examples.
 * Example
 * For strings = ["2,3", "1,8", "3,11"], the output should be
 * breakDown2(strings) = [2, 1, 3, 264, 88, 33, 24].
 * Layout:
 * c misc b
 * "2 , 3"
 * "1 , 8"
 * "3 , 11"
 * Output:
 * [c1, c2, c3, B, B1, B2, B3],
 * Where B = b1 * b2 * b3
 * And B# = B / b# where # = 1, 2, or 3
 * So, the output is:
 * [2, 1, 3, 264, 88, 33, 24].
 * 
 * NOTE!
 * The misc can be ANYTHING.
 * 
 * Input/Output
 * [execution time limit] 3 seconds (java)
 * [input] array.string strings
 * Guaranteed constraints:
 * strings.length = 3,
 * 1 ≤ numbers in strings < 10^10.
 * [output] array.integer64
 * 
 * An array as outlined above.
 *
 */
public class Breakdown2V2 {
	public static void main(String[] args) {
		String[][] ary = {
				{"2,3", "1,8", "3,11"}, //[2, 1, 3, 264, 88, 33, 24]
				{"5=8", "4=9", "1=11"}, //5, 4, 1, 792, 99, 88, 72
				{"3=5", "1=7", "2=7"},   //[3, 1, 2, 245, 49, 35, 35]
				{"1+5", "2+3",  "4+7"}, //[1, 2, 4, 105, 21, 35, 15]
				{"4*5", "5*6", "6*7"},//[4, 5, 6, 210, 42, 35, 30]
				{"1-2", "1-3",  "1-5"},//[1, 1, 1, 30, 15, 10, 6]
				{"2**11", "5**7", "13**19"},//[2, 5, 13, 1463, 133, 209, 77]
				{"7/9", "4/5", "10/13"},//[7, 4, 10, 585, 65, 117, 45]
				{"4#^*799", "5#^*999", "6#$^*9999"},
				{"4#34^*799","5#34^*999","6#34$^*9999"}
				
		};
		String[] expected = {
				"[2, 1, 3, 264, 88, 33, 24]",
				"[5, 4, 1, 792, 99, 88, 72]",
				"[3, 1, 2, 245, 49, 35, 35]",
				"[1, 2, 4, 105, 21, 35, 15]",
				"[4, 5, 6, 210, 42, 35, 30]",
				"[1, 1, 1, 30, 15, 10, 6]",
				"[2, 5, 13, 1463, 133, 209, 77]",
				"[7, 4, 10, 585, 65, 117, 45]",
				"[4, 5, 6, 7981211799, 9989001, 7989201, 798201]",
				"[4, 5, 6, 7981211799, 9989001, 7989201, 798201]"
		};
		int e=0;
		for (String[] s : ary) {
			long[] result = breakDown2(s);
			System.out.println("Input   :" + Arrays.toString(s));
			System.out.println("Expected:" + expected[e++]);
			System.out.println("Output  :"+ Arrays.toString(result));
			System.out.println("-------------------------");
		}
	}
	
	static long[] breakDown2(String[] in) {
	    long s[] = new long[7];
	    
	    Arrays.stream(in)
	    	  .forEach(x -> {
	    	  		String y[] = x.split("[^\\p{L}0-9']+");
	    	  		}
	    		);
	    
	    String s0[] = in[0].split("[^\\p{L}0-9']+");
	    String s1[] = in[1].split("[^\\p{L}0-9']+");
	    String s2[] = in[2].split("[^\\p{L}0-9']+");
	    s[0] = Long.parseLong(s0[0]); 
	    s[1] = Long.parseLong(s1[0]);
	    s[2] = Long.parseLong(s2[0]);
	    long b0 = Long.parseLong(s0[s0.length-1]);
	    long b1 = Long.parseLong(s1[s1.length-1]);
	    long b2 = Long.parseLong(s2[s2.length-1]);
	    s[3] = b0 * b1 * b2;
	    s[4] = b1 * b2;
	    s[5] = b0 * b2;
	    s[6] = b0 * b1;
	    return s;
	}

}
