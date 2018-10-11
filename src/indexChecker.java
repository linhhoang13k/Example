// https://codefights.com/challenge/v3iMgELuSGSKKHYrL/solutions/xRoqcTDSKMRax3JkM
int a;
int b;
long z;
String indexChecker(String l) {
    for(int i = l.length() - 1; i > -1; i--) {
        z += ((int) l.charAt(i) - 64) * Math.pow(26, b);
        b++;
    }
    return Long.toString(z);
}
