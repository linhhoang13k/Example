package tiendm.codefight.tournament.aug;

public class Tour2308 {
	int equalPairOfBits(int n, int m) {
		String sN = Integer.toBinaryString(n);
		String sM = Integer.toBinaryString(m);
		int i = 1;
		while (sN.length() - i >= 0 && sM.length() - i >= 0) {
			if (sN.charAt(sN.length() - i) == sM.charAt(sM.length() - i))
				break;
			i++;
		}
		return (int) Math.pow(2, i - 1);
	}

	int arrayMaximalAdjacentDifference(int[] inputArray) {
		int max = 0;
		for (int i = 1; i < inputArray.length; i++) {
			if (Math.abs(inputArray[i] - inputArray[i - 1]) > max) {
				max = Math.abs(inputArray[i] - inputArray[i - 1]);
			}
		}
		return max;
	}

	String cipher26(String message) {
		String str = "";
		for (int i = 0; i < message.length(); i++) {
			int s = 0;
			int c = message.charAt(i) - 'a';
			int cur = caculate(str);
			for (int j = 0; j < 26; j++) {
				if ((cur + j) % 26 == c) {
					str += (char) ('a' + j);
				}
			}
		}
		return str;
	}

	int caculate(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum += (s.charAt(i) - 'a');
		}
		return sum;
	}

	int exerciseElaboration(int p, int n) {
		String s = p + "";
		for (int i = 1; i <= n; i++) {
			s += 0 + "";
		}
		s += p;
		int x = Integer.parseInt(s);
		x *= x;
		String str = x + "";
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += str.charAt(i) - '0';
		}
		return sum;
	}

	boolean checkFactorial(int n) {
		int s = 1, i = 1;
		while (s * i <= n) {
			if (s * i == n)
				return true;
			i++;
		}
		return false;
	}

	int firstNotDivisible(int[] divisors, int start) {
		while (true) {
			int count = 0;
			for (int div : divisors) {
				if (start % div == 0) {
					break;
				}
				count++;
			}
			if (count == divisors.length) {
				return start;
			}
			start++;

		}
	}
	
	double[] quadraticEquation(int a, int b, int c) {
	    double d = b * b - 4 * a * c;
	    if(d < 0) return new double[]{};
	    if(d == 0) return new double[]{-b/(2*a)};
	    double cd = Math.sqrt(d);
	    return new double[]{(-b - cd)/(2*a),(-b + cd)/(2*a)};
	}


	public static void main(String[] args) {
		Tour2308 t = new Tour2308();
		int[] x = { 2, 3, 4 };
		System.out.println(t.firstNotDivisible(x, 14));
	}
}
