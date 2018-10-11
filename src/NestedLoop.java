package tiendm.codefight.core;

import java.util.ArrayList;
import java.util.List;

public class NestedLoop {
	boolean isPower(int n) {
		if(n == 0 || n == 1) return true;
		int limit = (int) Math.sqrt(n) , pre = n, x = n;
		for(int i = limit; i >= 2 ; i--) {
			if(x % i != 0) continue;
			if(x == i) return true;
			if(i != pre && pre != n) return false;
			pre = i;
			x = x / i;
			i++;
		}
		return false;
	}
	int isSumOfConsecutive2(int n) {
		int X = 2 * n, c = 0;
		for(int start = 1; start <= n/2 + 1 ; start++){
			for(int k = 1; k <= n-k+1; k++) {
				if(k * (k + 2*start - 1) == X) c++;
			}
		}
		return c;
	}
	
	int squareDigitsSequence(int a0) {
		List<Integer> sequences = new ArrayList<>();
		sequences.add(a0);
		while (true) {
			a0 = calculate(a0);
			if(sequences.contains(a0)) break;
			else{
				sequences.add(a0);	
			}
		}
		return sequences.size()+1;
	} 
	int calculate(int a) {
		int  m = 0, sum = 0;
		while(a > 0){
			m = a % 10;
			sum +=  m * m;
			a = a / 10;
		}
		return sum;
	}
	
	int pagesNumberingWithInk(int current, int numberOfDigits) {
		int next = (int)Math.log10(current) + 1;
		while (numberOfDigits >= next) {
			numberOfDigits -= next;
			current++;
			next = (int)Math.log10(current) + 1;
		}
		return current-1;
	}
	
	int comfortableNumbers(int L, int R) {
	    int[] s = new int[R+1];
	    int count = 0;
	    for(int i = L; i <= R; i++){
	        s[i] = countDigit(i);
	    }
	    for(int i = L; i <= R; i++){
	        int a= i;
	        for(int b = a+1 ; b <= a+s[i] ; b++){
	            if( b >= L && b <= R && b - s[b] <= a && b+s[b] >=a){
	                count++;
	            }
	        }
	    }
	    return count;
	}
	
	int countDigit(int i) {
	    int sum =0;
	    while (i > 0) {
	        sum += i % 10;
	        i = i/10;
	    }
	    return sum;
	}
	
	int[] weakNumbers(int n) {
		int[] d = new int[n+1];
		int[] w = new int[n+1];
		for(int i = 1; i <= n ; i++){
			d[i] = getDivisor(i);
		}
		for(int i = 1; i <=  n; i++){
			for(int j = i-1 ; j>=1; j--){
				if(d[j] > d[i]) w[i]++;
			}
		}
		int max = 0, nbMax =0;
		for(int i = 1; i <= n; i++){
			if(w[i] > max){
				max = w[i];
				nbMax = 1;
			} else if (w[i] == max) {
				nbMax++;
			}
		}
		int[] x = new int[]{max,nbMax};
		return x;
	}
	
	int getDivisor(int n) {
		int count = 0;
		for(int i = 1; i <= n; i++){
			if(n % i == 0) count++;
		}
		return count;
	}
	
	int rectangleRotation(int a, int b) {
		double maxWidth = a / 2 / Math.sqrt(2);
		double maxHeight = b / 2 / Math.sqrt(2);
		int width = (int) (Math.floor(maxWidth) * 2 + 1);
		int n = 0;
		if(maxWidth - Math.floor(maxWidth) < 0.5) {
			n = -1;
		} else {
			n = 1;
		}
		double count = 0.5;
		int sum = width;
		while (count < maxHeight) {
			if(count == Math.floor(count)) {
				sum += width *2;
			}else {
				sum += (width + n) * 2;
			}
			count += 0.5;
		}
		return sum;
	}
	
	int rectangleRotationSolution(int a, int b) {
		int r = 0;
	    for (int x = -a - b; x <= a + b; x++) {
	        for (int y = -a - b; y <= a + b; y++) {
	            if (2 * (x - y) * (x - y) <= a * a && 2 * (x + y) * (x + y) <= b * b)
	                r++;
	        }
	    }
	    return r;
	}
	
	public static void main(String[] args) {
		NestedLoop loop = new NestedLoop();
	}
}
