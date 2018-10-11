// https://codefights.com/challenge/ZbRKD2joQRumAfJJj/solutions/hLDpGvf2owiSxEyo9
int birthdays(int n) {
    double a = 1.0;
    for(double i = (double) n - 1, z = 1; i > 0; i--) {
        a *= i / n;
        z++;
        if(1 - a > 0.5)
            return (int) z;
        if(1 - a == 0.5)
            return (int) z + 1;
    }
    return 2;
}
