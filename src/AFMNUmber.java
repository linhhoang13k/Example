package tiendm.codefight.challenge.april;

public class AFMNUmber {
	int[] AFM_numbers(int b) {
		int[] x = {0,1};
		int c = 1;
		while (c < b) {
			x[0] = x[1];
			x[1] = 2 * x[1] + (c++)%2;
		}
		return x;
	}
	
	public static void main(String[] args) {
		AFMNUmber test = new AFMNUmber();
		System.out.println(test.AFM_numbers(1));
	}
}
