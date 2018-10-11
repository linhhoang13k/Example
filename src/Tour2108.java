package tiendm.codefight.tournament.aug;

public class Tour2108 {
	int fibonacciIndex(int n) {
		if(n == 1) return 0;
	    int max = (int) Math.pow(10,n-1);
	    int min = (n == 2) ? 0 : (int) Math.pow(10,n-2);
	    int c = 0;
	    for(int i = 0; ; i++){
	        if(f(i) >= min && f(i) < max){
	            c++;
	        }else{
	            return c;
	        }
	    }
	}

	int f(int n){
	    if(n == 0) return 0;
	    if(n == 1) return 1;
	    return f(n-1) + f(n-2);
	}

	public static void main(String[] args) {
		Tour2108 t = new Tour2108();
		System.out.println(t.fibonacciIndex(5));
	}
}
