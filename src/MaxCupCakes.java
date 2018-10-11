// https://codefights.com/challenge/LvQzQXWeEkAxQ6dLS/solutions/xwvtnZ8iLi9gEmaLF
int a;
int MaxCupCakes(int N, int[] P, int K) {
    if(K > N - P.length) {
        return -1;
    }
    for(int i = 0; i < P.length; i++) {
        if(P[i] <= K) {
            a++;
        }
    }
    int b = K + a;
    for(int i = 0; i < P.length; i++) {
        if(b == P[i]) {
            b++;
        }
    }
    return b;
}
