// https://codefights.com/challenge/9jYfbiLKQtwrD5mg3/solutions/j6aXxsZS87NRbAdEi
int a;
int hailstoneLength(int l) {
    for(int i = 0; ; i++) {
        int j = i;
        while(j > 1) {
            if(j % 2 == 0) {
                j /= 2;
                a++;
            }
            else {
                j = 3 * j + 1;
                a++;
            }
        }
        if(a == l) {
            a = i;
            break;
        }
        else
            a = 0;
    }
    if(l == 0)
        a = 1;
    return a;
}
