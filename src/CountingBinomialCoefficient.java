package tiendm.codefight.challenge.may;

public class CountingBinomialCoefficient {
	long countingBinomialCoefficient(int num, int prime) {
		long x = System.currentTimeMillis();
	    long all = (num+1)*(num+2)/2;
	    for(int n = prime; n <= num; n++){
	    	for(int k = 1; k < n; k++){
	    		if(k >= prime || n - k < prime) all--;
	    	}
	    }
	    System.out.println("time = " + ((System.currentTimeMillis()-x)/1000));
	    return all;
	}
	public static void main(String[] args) {
		CountingBinomialCoefficient test = new CountingBinomialCoefficient();
		System.out.println(test.countingBinomialCoefficient(99999, 7));
	}
}
