package challenges;

public class Base20 {

	public static void main(String[] args) {
		System.out.println(Base20(192));
	}

	static String Base20(int n) {
		String b = "";
		char cs[] = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };
		do {
			int r = n % 20;
			b = r > 9 ? cs[r - 10] + b : r + b;
			n = n / 20;
		} while (n > 0);
		return b;
	}
}