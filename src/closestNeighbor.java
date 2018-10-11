// https://codefights.com/challenge/hAJMvZbG3gvXqcF6g/solutions/iFWJCxQa683hG3pon
int[] closestNeighbor(int n, int a, int b, int c) {
    int[] d = new int[2];
	for(int i = 0; i < n; i++) {
		if(i % a == 0 && i % b == 0 && i % c == 0) {
			d[0] = i;
		}
	}
	for(int i = n + 1; ; i++) {
		if(i % a == 0 && i % b == 0 && i % c == 0) {
			d[1] = i;
			break;
		}
	}
    return d;
}
