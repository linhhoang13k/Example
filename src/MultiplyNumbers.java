// https://codefights.com/challenge/CFXmwm7d5MNEcyEhq/solutions/45nKCeoaFPDj7bSYd
static int[] f(List<Integer> x) {
        int q = x.size();
        String[] a = new String[q];
        int[] c = new int[q];
        int r = 0;
        for (int i = 0; i < q; i++) {
            a[i] = String.valueOf(x.get(i));
        }
        for (int i = 0; i < q; i++) {
            for (int j = 0, y = 0; j < q; j++) {
                if (j != i) {
                    while (a[i].length() > a[j].length()) {
                        a[j] = "0" + a[j];
                    }
                    while (a[i].length() < a[j].length()) {
                        a[i] = "0" + a[i];
                    }
                    for (int k = 0, z = 0; k < a[i].length(); k++) {
                        if ((Integer.parseInt(Character.toString(a[i].charAt(k))) * Integer.parseInt(Character.toString(a[j].charAt(k)))) % 10 == 0) {
                            z++;
                        } else {
                            c[j]++;
                        }
                        if (z == a[i].length()) {
                            y++;
                        }
                    }
                    if (y == a.length - 1) {
                        r++;
                    }
                }
            }
        }
    if(r == q) {
        int[] d = {-1};
        return d;
    }
    return c;
}
static int g(List<Integer> t) {
    int[] s = {-1};
    int[] w = f(t);
    if(w[0] == -1) {
        return t.size();
    }
    int v = w[0];
    int vv = 0;
    for(int i = 0; i < w.length; i++) {
        if(w[i] > v) {
            v = w[i];
            vv = i;
        }
    }
    t.remove(vv);
    return g(t);
}
static int MultiplyNumbers(int[] n) {
    ArrayList<Integer> t = new ArrayList<>();
    for(int i = 0; i < n.length; i++) {
        t.add(n[i]);
    }
    return g(t);
}
