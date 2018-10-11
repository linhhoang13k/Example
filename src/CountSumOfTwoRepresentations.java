ublic class CountSumOfTwoRepresentations {

	int countSumOfTwoRepresentations3(int n, int l, int r) {
	    int count = 0;
	    for (int i = l; i <= r; i++) {
	        int k = n - i;
	        if (k >= i && k >=l && k <= r) count++;
	    }
	    return count;
	}
