package tiendm.codefight.challenge.april;

public class MaxVassal {
//	int maxVassal(int num) {
//		int max = (int) Math.ceil(Math.cbrt(num))-1;
//		while (max >= 1) {
//			if(gcd(num,(int)Math.pow(max, 3)) > 1) return max;
//			max --;
//		}
//		return -1;
//	}
//	int gcd(int num1, int num2) {
//		if(num1 % num2 == 0) return num2;
//		else return gcd(num2, num1%num2);
//	}
	
	int maxVassal(int n) {
		int m = (int) Math.ceil(Math.cbrt(n))-1;
		while (m >= 1) {
			if(gcd(n,(int)Math.pow(m, 3)) > 1) return m;
			m --;
		}
		return -1;
	}
	int gcd(int x, int y) {
		if(x % y == 0) return y;
		else return gcd(y, x%y);
	}
	
	public static void main(String[] args) {
		MaxVassal maxVassal = new MaxVassal();
		System.out.println(maxVassal.maxVassal(27));
	}
}
