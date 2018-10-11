package tiendm.codefight.core;

import java.util.Stack;

public class CornerBit {
	int killKthBit(int n, int k) {
		return n & ~(1 << k);
//		return (n>>(k-1)) % 2 == 0 ? n : n - (int)Math.pow(2,k-1);
	}
	int arrayPacking(int[] a) {
		Stack<String> stack = new Stack<>();
		for(int i: a){
			String s = Integer.toBinaryString(i);
			if(s.length() < 8){
				s = String.format("%8s", s).replaceAll(" ", "0");
			}
			stack.push(s);
		}
		StringBuilder builder = new StringBuilder();
		while (!stack.isEmpty()) {
			builder.append(stack.pop());
		}
		String strResult = builder.toString();
		return Integer.parseInt(strResult,2);
	}
	int arrayPackingSolution(int[] a) {
		int result = 0, count =0;
		for(int i: a){
			result += i << (8*(count++));
		}
		return result;
	}
	
	int rangeBitCount(int a, int b) {
		int sum = 0;
	    for(int i = a; i <= b; i++){
	        int x = i;
	        while(x > 0){
	            sum += x & 1;
	            x = x >> 1;
	        }
	    }
	    return sum;
//		int sum = 0;
//		for(int i = a; i <= b; i++){
//			sum += Integer.bitCount(i);
//		}
//		return sum;
	}
	
	int mirrorBits(int a) {
	   int sum =0;
	   while(a > 0){
	      sum = (sum << 1) + (a & 1);
	      a = a >> 1;
	   }
	   return sum;
	}
	
	int swapBit(int n){
		int length = (int) (Math.log(n) / Math.log(2)) ;
		int sum = 0, bit1 = 0, bit2 = 0;
		for(int i = 0; i <= length; i+=2){
			bit1 = (n >> i) & 1;
			bit2 = (n >> (i+1)) & 1;
			sum += (bit1 << (i+1)) + (bit2 << i);
		}
		return sum;
	}
	
	int swapBitSolution(int n){
		return ((n & 0b01010101010101010101010101010101) << 1) 
					| ((n & 0b10101010101010101010101010101010) >> 1);
	}
	
	int differentRightmostBit(int n, int m) {
	    int idx = 0;
	    int c = n ^ m;
	    while((c&1) == 0){
	    	c = c >> 1;
			idx++;
	    }
	    return 1 << idx;
	}
	int differentRightmostBitSolution(int n, int m) {
		return (n^m) & -(n^m);
	}
	
	int equalPairOfBits(int n, int m) {
		int idx = 0;
	    int c = n ^ m;
	    while((c&1) == 1){
	    	c = c >> 1;
			idx++;
	    }
	    return 1 << idx;
	}
	
	int equalPairOfBitsSolution(int n, int m) {
	    return (n^m+1) & ~(n^m);
	}
	 

	
	public static void main(String[] args) {
		CornerBit test  = new CornerBit();
		int[] x = new int[]{24, 85, 0};
		System.out.println(test.differentRightmostBitSolution(7,23));
	}
}
