// https://codefights.com/challenge/b3kf2zTo7wfXGHqYn/solutions/ZEBdiGMGfjcDmJTcm
char[] AirlineSeating(char[] a, int p, int s) {
    int e = a.length;
    boolean b = p + s > e;
    int d = 0;
    for(int i = 0; i < e; i++) {
        if(a[i] == 'c')
            d++;
    }
    boolean c = s > d;
    for(int i = 0; i < e; i++) {
        if(a[i] == 'f') {
            if(p > 0) {
                a[i] = 'p';
                p -= 1;
            }
            else if((s > 0 && b) || (s > 0 && c)) {
                a[i] = 's';
                s -= 1;
            }
            else {
                a[i] = ' ';
            }
        }
        else if(a[i] == 'c' && s > 0) {
            a[i] = 's';
            s -= 1;
        }
        else {
            a[i] = ' ';
        }
    }
    return a;
}
