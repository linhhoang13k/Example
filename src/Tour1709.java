package tiendm.codefight.tournament.sep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Tour1709 {
	String truncateString(String s) {
		if (s.length() == 1) {
			if (Integer.parseInt(s) % 3 == 0) {
				return "";
			}
			return s;
		}
		if (getInt(s, 0) % 3 == 0)
			return truncateString(s.substring(1));
		if (getInt(s, s.length()-1) % 3 == 0)
			return truncateString(s.substring(0, s.length()-1));
		if ((getInt(s, 0) + getInt(s, s.length()-1)) % 3 == 0) {
			return truncateString(s.substring(1, s.length() - 1));
		}
		return s;
	}
	
	int getInt(String s, int idx){
		return s.charAt(idx) - '0';
	}
	
	Integer[] digitalSumSort(Integer[] a) {
		Arrays.sort(a, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				int x1 = countDigit(o1);
				int x2 = countDigit(o2);
				if(x1 == x2){
					return o1 - o2;
				}
				return x1-x2;
			}
		});
		return a;
	}
	int countDigit(int x) {
		int s = 0;
		while (x > 0) {
			s += x % 10;
			x /= 10;
		}
		return s;
	}

	public static void main(String[] args) {
		Tour1709 t = new Tour1709();
		int[] fromV = { 2, 1, 3, 4, 4, 4, 1 };
		int[] toV = { 3, 2, 1, 3, 2, 1, 4 };
		System.out.println(t.truncateString("312248"));
	}
}
