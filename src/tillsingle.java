// https://codefights.com/challenge/J8qXEKPYt4mtnMPaR/solutions/46RXFhjYPx8RSnDRN
int b;
int tillsingle(String n) {
    String[] a = new String[2];
    double c = 0;
    if(n.contains("^")) {
        for(int i = 0; i < n.length(); i++) {
            if(n.charAt(i) == '^') {
                a[0] = n.substring(0, i);
                a[1] = n.substring(i + 1, n.length());
                c = Math.pow(Integer.parseInt(a[0]), Integer.parseInt(a[1]));
            }
        }
    }
    else {
        c = Integer.parseInt(n);
    }
    while(c > 0) {
        b += c % 10;
        c /= 10;
    }
    while(b > 9) {
        c = b;
		b = 0;
		while(c > 0) {
			b += c % 10;
			c /= 10;
		}
	}
    return b;
}
