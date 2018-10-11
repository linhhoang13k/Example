package tiendm.codefight;

public class Util {
	boolean binarySearch(int[] arr, int i, int begin, int end) {
		if(begin == end) {
			return arr[begin] == i;
		}
		int mid = (begin+end) /2;
		if(arr[mid] == i) return true;
		else if (arr[mid] < i) {
			return binarySearch(arr, i, mid+1, end);
		}else{
			return binarySearch(arr, i, begin, mid);
		}
	}
	
	boolean isPrime(int x) {
		if (x == 2 || x == 3)
			return true;
		for (int i = 2; i <= x / 2 ; i++) {
			if (x % i == 0)
				return false;
		}
		return true;
	}

	int chessKnight(String cell) {
		int row = Integer.parseInt("" + cell.charAt(1)), column = cell.charAt(0) - 'a' + 1;
		int[][] steps = { { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 } };
		int answer = 0;

		for (int i = 0; i < steps.length; i++) {
			int tmpRow = row + steps[i][0];
			int tmpColumn = column + steps[i][1];
			if (tmpRow >= 1 && tmpRow <= 8 && tmpColumn >= 1 && tmpColumn <= 8) {
				answer++;
			}
		}

		return answer;
	}

	int countSumOfTwoRepresentations(int n, int l, int r) {
		int result = 0;
		for (int a = l; a <= r; a++) {
			for (int b = a; b <= r; b++) {
				if (a + b == n) {
					result++;
					break;
				}
			}
		}
		return result;
	}

	int countSumOfTwoRepresentations2(int n, int l, int r) {
		int c = 0;
		for (int i = l; i <= r; i++) {
			if (i <= n - i && n - i <= r)
				c++;
		}
		return c;
	}

	int countSumOfTwoRepresentations3(int n, int l, int r) {
		int result = 0;

		for (int i = 1; i <= n - i; i++) {
			if (l <= i && n - i <= r) {
				result++;
			}
		}

		return result;
	}
	
	int countDigit(int x) {
		int s = 0;
		while (x > 0) {
			s += x % 10;
			x /= 10;
		}
		return s;
	}
	
	int gcd(int a, int b){
		while(a % b != 0){
			int tmp = b;
			b = a % b;
			a = tmp;
		}
		return b;
	}

	public static void main(String[] args) {
		Util u = new Util();
		System.out.println(u.gcd(15, 9));
	}
}
