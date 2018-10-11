package tiendm.codefight.tournament.aug;

import java.util.ArrayList;
import java.util.List;

public class Tour2508 {

	int equalPairOfBits(int n, int m) {
		int i = 0;
		while (n > 0 && m > 0) {
			int n1 = n % 2;
			int m1 = m % 2;
			if (n1 == m1)
				return (int) Math.pow(2, i);
			else {
				i++;
				n /= 2;
				m /= 2;
			}
		}
		return (int) Math.pow(2, i);
	}

	int lateRide(int s) {
		int m = s / 60;
		int n = s % 60;
		int sum = 0;
		sum += m / 10 + m % 10;
		sum += n / 10 + n % 10;
		return sum;
	}

	List<String> splitAddress(String address) {
		List<String> result = new ArrayList<>();
		String[] s1 = address.split(":\\/\\/");
		result.add(s1[0]);
		int dot = s1[1].indexOf('.');
		result.add(s1[1].substring(0, dot));
		String[] s2 = s1[1].split("\\/");
		for (int i = 1; i < s2.length; i++) {
			result.add(s2[i]);
		}
		return result;
	}

	int neighbouringElements(int[][] a) {
		int s = 0;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a[0].length - 1; j++) {
				if (a[i][j] == a[i + 1][j])
					s++;
				if (a[i][j] == a[i][j + 1])
					s++;
			}
		}
		for (int i = 0; i < a[0].length - 1; i++) {
			if (a[a.length - 1][i] == a[a.length - 1][i + 1])
				s++;
		}
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i][a[0].length - 1] == a[i + 1][a[0].length - 1])
				s++;
		}
		return s;
	}

	List<Integer> primeFactors2(int n) {
		List<Integer> rs = new ArrayList<>();
		for (int i = 2; i <= n; i++) {
			if (n % i == 0 && isPrime(i)) {
				rs.add(i);
			}
		}
		return rs;
	}

	boolean isPrime(int x) {
		if (x == 2 || x == 3)
			return true;
		for (int i = 2; i < x / 2 + 1; i++) {
			if (x % i == 0)
				return false;
		}
		return true;
	}
	boolean isPower(int n) {
	    for(int i = 2; i < n; i++){
	        for(int j = 1; j < n; j++){
	            if(Math.pow(i,j) == n){
	                return true;
	            }else if(Math.pow(i,j) > n){
	                break;
	            }
	        }
	    }
	    return false;
	}
	
	double computeDefiniteIntegral(int l, int r, int[] p) {
	    return caculeintegral(r, p) - caculeintegral(l, p);
	}

	double caculeintegral(int x, int[] p){
	    double sum = 0.0;
	    for(int i = 0; i < p.length; i++){
	    	sum += (double)(p[i] * Math.pow(x, i+1) /(i+1));
	    }
	    return sum;
	}

	public static void main(String[] args) {
		Tour2508 t = new Tour2508();
		int[][] x = { { 0, 1, 2, 3 }, { 1, 2, 3, 0 }, { 1, 1, 1 } };
		int[] p = {0, 0, 0, 1};
		System.out.println(t.computeDefiniteIntegral(-1,2,p));
	}
}
