package tiendm.codefight.challenge.april;

public class NewtonInterpolation {
	
	long extrapolation(long[] y) {
		int n = y.length;
		double[] a = new double[n];
		a[0] = y[0];
		for(int i = 1; i < n ; i++){
			a[i] = (y[i] - calF(i+1, a)) / calX(i+1,i); 
		}
		double r = calF(n+1, a);
		if(r - Math.floor(r) >=0.6) return Math.round(r);
		else return (long) r;
	}
	
	private double calX(int x, int i) {
		double r = 1;
		for(int j = 1; j <= i; j++){
			r *= (x - j);
		}
		return r;
	}
	
	double calF(int x, double[] a) {
		double y = a[0];
		for(int i = 1; i < x - 1; i++){
			y += a[i] * calX(x,i);
		}
		return y;
	}

	public static void main(String[] args) {
		NewtonInterpolation test = new NewtonInterpolation();
		long[] x = {3, 1, 4, 1, 5, 9, 2, 6};
		System.out.println(test.extrapolation(x));
	}
}
