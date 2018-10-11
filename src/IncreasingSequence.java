package codefights.arcade;

public class IncreasingSequence {
	static boolean almostIncreasingSequence(int[] sequence) {
	    int numErr = 0;
	    for (int i = 0; i < sequence.length - 1; i++) {
	      if (sequence[i] - sequence[i+1] >= 0) {
	            numErr += 1;
	            if ((i - 1 >= 0) && (i + 2 <= sequence.length - 1)
	               && (sequence[i] - sequence[i+2] >= 0)
	               && (sequence[i-1] - sequence[i+1] >=0)) {
	                return false;
	            }
	        }
	    }
	    
	    return numErr <= 1;
	}
	

	
	public static void main(String[] args) {

		int[] sequence = { 5,1,2 };

		System.out.println(almostIncreasingSequence(sequence));
	}

}


