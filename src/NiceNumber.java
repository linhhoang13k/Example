package tiendm.codefight.challenge.april;

public class NiceNumber {
	int pNiceNumbers(int n, int p) {
		int count = n;
		for(int i = 1; i <= n; i++){
			if(C(i,n) % p != 0) count--;
		}
		return count;
	}
	
	int C(int k, int n){
		return N(n) / (N(k) * N(n-k));
	}
	int N(int n){
		int x = 1;
		for(int i = 1; i <= n ; i++) {
			x *= i;
		}
		return x;
	}
	public static void main(String[] args) {
		NiceNumber test = new NiceNumber();
		System.out.println(test.pNiceNumbers(16, 2));
	}
}
