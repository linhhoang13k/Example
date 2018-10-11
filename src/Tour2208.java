package tiendm.codefight.tournament.aug;

import java.util.Arrays;

public class Tour2208 {
	int factorSum(int n) {
		int next = 0;
		for (int i = 2; i <= n; i++) {
			if (n % i == 0 && isPrime(i)) {
				next += i;
				n /= i;
				i = 1;
			}
			if (n == 1)
				break;
		}
		if (isPrime(next))
			return next;
		return factorSum(next);
	}

	boolean isPrime(int x) {
		if (x == 2 || x == 3)
			return true;
		for (int i = 2; i < x / 2; i++) {
			if (x % i == 0)
				return false;
		}
		return true;
	}
	
	int comeOnDown(int maxPrice, int[] bids) {
	    Arrays.sort(bids);
	    int max = 0, maxValue = 0;
	    for(int i = 0; i < bids.length-1; i++){
	        int check = bids[i+1] - bids[i] - 1;
	        if(check > maxValue && bids[i+1] < maxPrice){
	            maxValue = check;
	            max = bids[i]+1;
	        }else if (bids[i+1] > maxPrice && bids[i] < maxPrice && maxPrice - bids[i] - 1 > maxValue) {
	        	maxValue = maxPrice - bids[i] - 1;
	        	max = bids[i]+1;
			}
	    }
	    
	    return maxValue > bids[0] - 1 ? max : 1;
	}

	public static void main(String[] args) {
		Tour2208 t = new Tour2208();
		int[] x = {2727, 6430, 833, 6744, 6685, 9266, 713, 803, 2940, 9662};
		System.out.println(t.comeOnDown(5999, x));
	}
}
