// https://codefights.com/challenge/sfW9pdqpfDCiasbX6/solutions/kvDju5FoCwh97tZC8
int MultipleNumber(String n) {
    int x = 1;
    long y = Long.parseLong(n);
    if(y == 0)
        return 0;
    while(y > 0) {
        x *= y % 10;
        y /= 10;
    }
    x = x >= 10 ? MultipleNumber(Integer.toString(x)) : x;
    return x;
}
