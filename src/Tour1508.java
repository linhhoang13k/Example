package tiendm.codefight.tournament.aug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tour1508 {
	boolean isPangram(String sentence) {
		int[] occ = new int[26];
		sentence = sentence.toUpperCase();
		for (int i = 0; i < sentence.length(); i++) {
			occ[sentence.charAt(i) - 'A']++;
		}
		for (int i = 0; i < occ.length; i++) {
			if (occ[i] == 0)
				return false;
		}
		return true;
	}

	int[] makeArrayConsecutive(int[] sequence) {
		Arrays.sort(sequence);

		int[] result = new int[sequence[sequence.length - 1] - sequence[0] + 1 - sequence.length];
		int c = 0;
		for (int i = sequence[0] + 1; i < sequence[sequence.length - 1]; i++) {
			if (Arrays.binarySearch(sequence, i) == -1) {
				result[c++] = i;
			}
		}
		return result;
	}

	List<Integer> primeFactors2(int n) {
		List<Integer> a = new ArrayList<>();
		for (int i = 2; i <= n; i++) {
			if (isPrime(i) && n % i == 0) {
				a.add(i);
			}
		}
		return a;
	}

	boolean isPrime(int n) {
        if(n == 2) return true;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i== 0) {
				return false;
			}
		}
		return true;
	}
	int firstMultiple(int[] divisors, int start) {
	    int i = start;
	    for(i = start; ; i++){
	        int c = 0;
	        for(int x : divisors){
	            if(i % x == 0){
	                c++;
	            }else{
	                break;
	            }
	        }
	        if(c == divisors.length) return c;
	    }  
	}

	public static void main(String[] args) {
		Tour1508 t = new Tour1508();
		int[] x = { 6, 2, 3, 8 };
		System.out.println(t.primeFactors2(100));
	}
}
