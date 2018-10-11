// https://codefights.com/challenge/iBJCkwKHBdMiuxfHF/solutions/ctsmaaTZbE5NXkhFP
int pattern(int i) {
    int a = 1;
    while(i > 1) {
        a++;
        a *= 2;
        i--;
    }
    return a;
}
