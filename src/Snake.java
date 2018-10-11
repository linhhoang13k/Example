package tiendm.codefight.challenge.august;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Snake {
	int[][] charLocation1(String tex, int wid, char ch) {
		List<Integer[]> result = new ArrayList<>();
		for (int i = 0; i < tex.length(); i++) {
			char c = tex.charAt(i);
			if (c != ch)
				continue;
			int x1 = i / wid;
			int x2 = i % wid;
			int idx = result.size() - 1;
			if (x1 % 2 == 1) {
				x2 = wid - 1 - x2;
				while (idx >= 0 && result.get(idx)[1] == x1) {
					idx--;
				}
			}
			Integer[] x = { x1, x2 };
			result.add(idx + 1, x);
		}
		int[][] a = new int[result.size()][2];
		for (int i = 0; i < a.length; i++) {
			a[i] = new int[2];
			a[i][0] = result.get(i)[0];
			a[i][1] = result.get(i)[1];
		}
		return a;
	}

	int[][] charLocation(String tex, int wid, char ch) {
		char[][] chars = new char[tex.length() / wid + 1][wid];
		int count = 0;
		for (int i = 0; i < tex.length(); i++) {
			char c = tex.charAt(i);
			if ((i / wid) % 2 == 0) {
				chars[i / wid][i % wid] = c;
			} else {
				chars[i / wid][wid - 1 - i % wid] = c;
			}
			if (c == ch)
				count++;
		}
		int[][] result = new int[count][2];
		int c = 0;
		for (int i = 0; i < chars.length; i++) {
			for (int j = 0; j < wid; j++) {
				if (chars[i][j] == ch) {
					result[c][0] = i;
					result[c][1] = j;
					c++;
				}
			}
		}
		return result;
	}
	
	int maxZeros(int n) {
	    String s = Integer.toBinaryString(n);
	    int count = 0;
	    for(int i = 0; i < s.length(); i++){
	        char c = s.charAt(i);
	        if(c == '0'){
	            count++;
	        }
	    }
	     return count;   
	}
	
	int kthDivisor(int n, int k) {
	    int c = 0;
	    for(int i = 0; i < n; i++){
	        if(n % i == 0) c++;
	        if(c == k) return i;
	    }
	    return 0;
	}

	public static void main(String[] args) {
		Snake snake = new Snake();
		System.out.println(snake.maxZeros(7));
	}
}
