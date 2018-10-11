// https://codefights.com/challenge/gYmPtoQQzcA7SesFA/solutions/9NkvNhuNKfT2spSR4
int[] errorProcessing(int N, int[][] signals) {
    int d = signals[0].length;
    int[] a = new int[d];
    int b = 0;
	int c = 0;
	for(int i = 0; i < d; i++) {
		for(int j = 0; j < N; j++) {
			if(signals[j][i] == 1) {
				b++;
			}
			else {
				c++;
			}
			if(b + c == N) {
				if(b > c) {
					a[i] = 1;
				}
				else {
					a[i] = 0;
				}
			b = 0;
			c = 0;
			}
		}
	}
   return a;
}
