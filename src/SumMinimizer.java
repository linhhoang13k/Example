package exercise32;

public class SumMinimizer {

	public int getAbsolute(int x) {
		int absolute = x;
		if (absolute < 0) {
			absolute = x * -1;
		}
		return absolute;
	}

	public int absoluteValuesSumMinimization(int[] a) {

		int x = 0;
		if (a.length % 2 == 0) {
			x = a[(a.length / 2) - 1];
			}
		else {
			x = a[((a.length + 1) / 2) - 1];
			}
		
		return x;
	}

}
