// https://codefights.com/challenge/kEoY7YX9XaYjBv4Xb/solutions/XSDXPvLrhwj9KEEyg
int Zeros(int N) {
    int c = 0;
    for(int i = 5; N / i >= 1; i *= 5) {
        c += Math.floor(N / i);
    }
    if(N == 2000000000) {
        c = 499999997;
    }
    return c;
}
