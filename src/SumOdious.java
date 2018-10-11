package tiendm.codefight.challenge.april;

public class SumOdious {
	int sumOdious(int k){
		int sum =0, n =1, count=0;
		int div = (int) (Math.pow(10, 6) + 7);
		while (count < k) {
			if(checkOdious(n)){
				sum += n;
				count++;
				sum = sum % div;
			}
			n++;
		}
		return sum % div;
	}
	
	boolean checkOdious(int n) {
		return (Integer.bitCount(n) & 1) == 1;
	}

	public static void main(String[] args) {
		SumOdious s = new SumOdious();
		System.out.println(s.sumOdious(12345));
	}
}
