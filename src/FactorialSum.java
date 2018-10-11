// https://codefights.com/challenge/yhN2jyWsWDTWA4qnW/solutions/8RWX98BB5nAycLzSS
int b;
int FactorialSum(int n) {
    long a = 1;
    for(int i = 0; i < n; i++) {
        a *= n - i;
    }
    while(a > 0) {
        b += a % 10;
        a /= 10;
    }
    return b;
}
