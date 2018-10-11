// https://codefights.com/challenge/YhSoJczcT25LtkyuY/solutions/7okYszwpNmMEpYmoo
int b;
int d;
int combinePasture(int[] v) {
	int a = 999;
	int c = 999;
	for (int i = 0; i < v.length; i++) {
		int e = v[i];
		if (i % 2 == 0) {
			if (e < a)
				a = e;
			if (e > b)
				b = e;
		} else {
			if (e < c)
				c = e;
			if (e > d)
				d = e;
		}
	}
	int f = b - a;
	int g = d - c;
	return f < g ? g * g : f * f;
}
