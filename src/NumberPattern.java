// https://codefights.com/challenge/JaXjh3uS48J4bFeuo/solutions/XHEM6s6h2MiGMPdJk
String[] NumberPattern(int[] n) {
    String[] b = new String[0];
    ArrayList<Integer> c = new ArrayList<>();
    int z = n.length;
    for(int i = 0, a = 0; i < z - 1; i++) {
        a = n[i + 1] - n[i];
        c.add(a);
        int y = c.size();
        for(int j = 1, d = 0; j < z; j++) {
            if(n[j] == n[j - 1] + c.get((j - 1) % y))
                d++;
            if(d == z - 1) {
                String[] e = new String[y];
                for(int k = 0; k < y; k++) {
                    int x = c.get(k);
                    if(x > -1) {
                        e[k] = "+" + x;
                    }
                    else {
                        e[k] = Integer.toString(x);
                    }
                }
                return e;
            }
        }
    }
    return b;
}
