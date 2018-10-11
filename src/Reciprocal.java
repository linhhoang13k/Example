package tiendm.codefight.challenge.april;

import java.math.BigDecimal;

public class Reciprocal {
	int reciprocal(int n, int d) {
		BigDecimal x = new BigDecimal((double) 1/n);
		if(d > 16) d = 16;
		String s = String.format("%."+d+"f", x);
		String s2 = String.format("%."+(d+1)+"f", x);
		int result = Integer.parseInt(s.substring(s.length()-1));
		return Integer.parseInt(s2.substring(s2.length()-1)) >= 5 ? result-1 : result;
	}
	public static void main(String[] args) {
		Reciprocal reciprocal = new Reciprocal();
		System.out.println(reciprocal.reciprocal(12345, 987654321));
	}
}
