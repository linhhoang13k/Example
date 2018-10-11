// https://codefights.com/challenge/2Cc55jAJ3M6PnY7n4/solutions/HCAJPPko3Fdmj9gXe
int z, y = 0;
int CountCarries(int a, int b) {
    int c = b;
    if(a < b)
        c = a;
    for(int i = 0; i < String.valueOf(c).length(); i++) {
        if(a % 10 + b % 10 + y > 9) {
            y = 1;
            z++;
        }
        else
            y = 0;
        a /= 10;
        b /= 10;
    }
    if(a > b) {
        if(a % 10 + y > 9)
            z++;
    }
    else 
        if(b % 10 + y > 9)
            z++;
    return z;
}
