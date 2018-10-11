package tiendm.codefight.introduction;

public class Level8 {
	int[] extractEachKth(int[] inputArray, int k) {
		int[] result = new int[inputArray.length - (inputArray.length/k)];
		int count = 0;
		for(int i = 0; i < inputArray.length; i++) {
			if((i + 1) % k == 0) continue;
			result[count++] = inputArray[i];
		}
		return result;
	}
	
	char firstDigit(String inputString) {
		int count = 0;
		while(count < inputString.length()){
			char c = inputString.charAt(count);
			if(c >= '0' && c <= '9') return c;
			count++;
		}
		return Character.MIN_VALUE;
	}
	
	int differentSymbolsNaive(String s) {
		int[] occurent = new int[Character.MAX_VALUE - Character.MIN_VALUE];
		for(int i = 0; i < s.length(); i++){
			occurent[s.charAt(i) - 'a']++;
		}
		int count = 0;
		for(int i : occurent){
			if(i > 0) count++;
		}
		return count;
	}
	
	int arrayMaxConsecutiveSum(int[] inputArray, int k) {
	    int max = 0;
	    int[] sum = new int[inputArray.length-k+1];
	    int count = 0;
	    for(int i = 0; i < k ; i++){
	        sum[0] += inputArray[i];
	    }
	    for(int i = 1; i < inputArray.length-k+1; i++){
	    	sum[++count] = sum[count-1] + inputArray[i+k-1] - inputArray[i-1];
	    }
	    for(int i : sum){
	    	if(i > max) max = i;
	    }
	    return max;
	}

	
	public static void main(String[] args) {
		Level8 test = new Level8();
		int[] inputArray = {2, 3, 5, 1, 10};
		System.out.println(test.arrayMaxConsecutiveSum(inputArray, 2));
	}
}
