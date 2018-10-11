package tiendm.codefight.challenge.april;

public class Lagrange {
	long extrapolation(long[] y) {
		int n = y.length;
		double[] a = new double [n];
		for(int i = 0; i< n; i++){
			a[i] = 1;
			for(int j = 0; j < n; j++){
				if(i != j) {
					a[i] *= (long)((i+1) - (j+1)); 
				}
			}
			a[i] = (double) (y[i] / a[i]);
		}
		
		return f(n+1,a);
	}
	
	long f(int v, double[] a){
		int n = a.length;
		double f = 0;
		for(int i = 0; i < n; i ++){
			long x_i = cal(v,i+1,n);
			double f_i = x_i * a[i];
			f += f_i;
		}
		return (long) Math.round(f);
	}
	
	long cal(int x, int i, int n){
		long y = 1;
		for(int j = 1; j <= n; j++){
			if(i != j) {
				y *= (x - j); 
			}
		}
		return y;
	}
	
	public static void main(String[] args) {
		Lagrange test = new Lagrange();
		long[] x = {1,4,9,16,25};
		System.out.println(test.extrapolation(x));
	}
}
