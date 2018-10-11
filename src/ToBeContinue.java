package tiendm.codefight.challenge.april;

import java.util.ArrayList;
import java.util.List;

public class ToBeContinue {
	int[] toBeContinued(int[] f) {
		List<Integer> l = new ArrayList<>();
		if(f[1] ==0) return new int[0];
		int m = 1,d = f[1],n = f[0];
		while(m > 0){
			m = n % d;
			l.add(n/d);
			n = d;
			d = m;
		}
		int[] x = new int[l.size()];
		for(int i: l){
			x[m++] = i;
		}
		return x;
	}
	
	public static void main(String[] args) {
		ToBeContinue test = new ToBeContinue();
		int[] x = {0,1};
		System.out.println(test.toBeContinued(x));
	}
}
