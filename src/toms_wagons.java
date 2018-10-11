// https://codefights.com/challenge/X8dWNNGxbAAnMkBaB/solutions/3cDFZeEb6EuGd3AF4
int b;
int toms_wagons(int m, int d, int n) {
    int[] a = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    for(int i = 1; i <= n; i++) {
        b += d + d - 1;
        if(d == a[m - 1]) {
            if(m == 12)
                m = 1;
            else
                m++;
            d = 0;
        }
        d++;
    }
    return b;
}
