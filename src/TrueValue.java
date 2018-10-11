// https://codefights.com/challenge/qqWWuFHbipD4B83Tv/solutions/A7ZNjFaqmrNWKEHcP
int TrueValue(int n) {
    String a = String.valueOf(n);
    int l = a.length();
    int z = 0;
    for(int i = 1; i < l + 1; i++) {
        z += (a.charAt(l - i) - '0') * i;
    }
    if(z > 9) {
        z = TrueValue(z);
    }
    return z;
}
