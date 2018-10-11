// https://codefights.com/challenge/z6jikHZ7iumoDB86m/solutions/WhmByzAmTCzbsgTwF
int a;
int c;
int SumItUp(int n, int k) {
	int b = 1;
    int l = 1;
	for(int i = 0; i < k; i++) {
		for(int j = l; l < j + n + 1; l++) {
			c = j;
			b *= l;
		}
		l = c + 1;
		a += b;
		b = 1;
	}
	return a;
}
