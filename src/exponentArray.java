// https://codefights.com/challenge/N4mvfyCCCNFYmC5YH/solutions/utZ6pYgBaNuShjTwN
int[] exponentArray(int n) {
    int a = 1;
    int b = 0;
    int c = 0;
    while(b <= n) {
        c += 1;
        b += a;
        a += 2;
    }
    a = 1;
    b = 1;
    int[] d = new int[c - 1];
    for(int i = 0; b <= n; i++) {
        if(b <= n){
            d[i] = b;
        } 
        a += 2;
        b += a;
    }
    return d;
}
