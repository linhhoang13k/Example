package tiendm.codefight.challenge.april;

import java.util.HashMap;
import java.util.Map;

public class MaxDisCount {
	
	int maxDiscount(int[] prices) {
	    int[] mins = new int[prices.length-2];
	    for(int i = 0; i < prices.length-2; i++){
	        mins[i] = Math.min(prices[i+2], Math.min(prices[i], prices[i+1])); 
	    }
	    Map<Integer, Integer> track = new HashMap<>();
	    return solve(mins,0,track);
	}
	int solve(int[] mins, int idx, Map<Integer, Integer> track) {
		Integer l = mins.length, max = 0, s3, s1;
		if(l <= 3) {
			for(int i : mins) {
				if (i > max) max = i;
			}
			return max;
		}
		if(idx >= mins.length - 3) {
			max = 0;
			for(int i = idx; i < l; i++){
				if(mins[i] > max) max = mins[i];
			}
			return max;
		} else {
			s3 = track.get(idx+3);
			if(s3 == null) {
				s3 = solve(mins, idx+3,track);
				track.put(idx+3, s3);
			}
			s1 = track.get(idx+1);
			if(s1 == null) {
				s1 = solve(mins, idx+1,track);
				track.put(idx+1, s1);
			}
			return Math.max(mins[idx] + s3, s1);
		}
	}
	
	public static void main(String[] args) {
		MaxDisCount test = new MaxDisCount();
		int[] x = {85, 23, 22, 94, 27, 23, 86, 25, 85, 90, 73, 67};
		System.out.println(test.maxDiscount(x));
	}
}
