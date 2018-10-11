// https://codefights.com/challenge/t3kA22kRxnPCSkQGZ/solutions/usKLXnHesMRNKT9LJ
int SnailCoordinate(int N) {
    int a = 0,
    b = 0,
    c = 0;
    for(int i = 1; i < N; i++) {
        c++;
        if(c == 5) {
            c = 1;
        }
        if(c == 1) {
            a *= -1;
            a += 1;
        }
        if(c == 2) {
            b *= -1;
            b += 1;
        }
        if(c == 3) {
            a *= -1;
        }
        if(c == 4) {
            b *= -1;
        } 
    }
    return a + b;
}
