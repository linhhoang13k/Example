package exercise9;

public class InfiniteProcess {

	public boolean isInfiniteProcess(int a, int b) {
		while (a <= b) {
			if (a == b) {
				return false;
			} else {
				a++;
				b--;
			}
		}
		return true;
	}

}
