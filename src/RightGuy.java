package tiendm.codefight.challenge.april;

public class RightGuy {
	int rightGuy(int k) {
		int m = (int) (Math.log(k) / Math.log(2)) , c = 0, i = 0;
		while(i++ <= m){
			if(k % Math.pow(2, i) == 0) c++;
		}
		return c;
	}
//	int rightGuy(int k) {
//		int c = 0, x = 1;
//		do {
//			x *= 2;
//			if(k % x == 0) c++;
//		} while (x <= k && c < 30);
//		return c+1;
//	}
	public static void main(String[] args) {
		RightGuy test = new RightGuy();
		System.out.println(test.rightGuy(1073741824));
	}
}
