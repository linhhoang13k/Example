package tiendm.codefight.challenge.may;

public class SumSquares {
	int sumSquares(long k) {
		long limit = (long) Math.sqrt(k);
		int count = 0;
		for(long i = 1; i <= limit; i++){
			long x = k - i * i;
			long y = (long) Math.ceil(Math.sqrt(x)); 
			if(Math.sqrt(x) == y) count++;
		}
		return count;
	}
	public static void main(String[] args) {
		SumSquares test = new SumSquares();
		System.out.println(test.sumSquares(25));
	}
}
