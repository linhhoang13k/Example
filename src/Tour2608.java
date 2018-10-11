package tiendm.codefight.tournament.aug;

import java.util.ArrayList;
import java.util.List;

public class Tour2608 {

	int comfortableNumbers(int l, int r) {
		boolean[][] comfortable = new boolean[r + 1][];
		for (int a = l; a <= r; a++) {
			int sa = count(a);
			boolean[] comfor = new boolean[a + sa + 1];
			for (int i = a - sa; i <= a + sa; i++) {
				comfor[i] = true;
			}
			comfortable[a] = comfor;
		}
		int sum = 0;
		for (int i = l; i < r; i++) {
			boolean[] comforX = comfortable[i];
			for (int j = i + 1; j <= r; j++) {
				boolean[] comforY = comfortable[j];
				if (j < comforX.length && i < comforY.length && comforX[j] && comforY[i])
					sum++;
			}
		}
		return sum;
	}
	
	int comfortableNumbers2(int l, int r) {
		int sum = 0;
		for (int a = l; a < r; a++) {
			int sa = count(a);
			for (int b = a + 1; b <= r; b++) {
				int sb = count(b);
				if (a - sa <= b && a + sa >= b && b - sb <= a && b + sb >= a){
					sum++;
				}
			}
		}
		return sum;
	}

	int count(int x) {
		int s = 0;
		while (x > 0) {
			s += x % 10;
			x /= 10;
		}
		return s;
	}

	List<String> isDivisibleBy6(String inputString) {
	    List<String> ls = new ArrayList<>();
	    
	    for(int i = 0; i < 10; i++){
	        String s = inputString.replace('*', (char)('0' + i));
	        int a = Integer.parseInt(s);
	        if(a % 6 == 0) ls.add(s);
	    }
	    return ls;
	}
	int countLineColorings(int points, int colors) {
	    return colors * (int)Math.pow(colors-1, points-1);
	}

	public static void main(String[] args) {
		Tour2608 t = new Tour2608();
		int[][] x = { { 0, 1, 2, 3 }, { 1, 2, 3, 0 }, { 1, 1, 1 } };
		int[] p = { 0, 0, 0, 1 };
		System.out.println(t.isDivisibleBy6("1*0"));
	}
}
