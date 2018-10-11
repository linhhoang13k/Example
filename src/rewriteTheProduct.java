// https://codefights.com/challenge/JniZDbhDmb97REtXj/solutions/xzP2KsgCwzoApRrab
int[][] rewriteTheProduct(int a, int b, int c, int d) {
    ArrayList<int[]> z = new ArrayList<>();
	int e = (a * a + b * b) * (c * c + d * d);
	for(int i = 1; i < e; i++) {
        for(int j = 2; j < e; j++) {
			if(i * i + j * j == e) {
				int[] f = {i, j};
                int h = z.size();
				if(h > 0) {
					for(int k = 0, g = 0; k < h; k++) {
						if(i + j != z.get(k)[0] + z.get(k)[1]) {
							g++;
							if(g == h) {
								z.add(f);
								g = 0;
							}
						}
					}
				}
				else {
					z.add(f);
				}
			}
		}
	}
    int[][] y = new int[z.size()][2];
    for(int i = 0; i < z.size(); i++) {
        y[i] = z.get(i);
    }
		return y;
}
