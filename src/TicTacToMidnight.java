// https://codefights.com/challenge/zhCxjYDCe74BxTW3q/solutions/FcyxbXYwsZqYBifxH
int TicTacToMidnight(String c) {
    String[] a = c.split(":");
    int n = 1440 - (60 * Integer.parseInt(a[0]) + Integer.parseInt(a[1]));
    if(n == 1440)
        return 0;
    return n;
}
