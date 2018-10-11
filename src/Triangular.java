// https://codefights.com/challenge/MQWWZHNQRc8Ttrxni/solutions/7PYhZYD4rzrSS5zY9
int a;
boolean Triangular(int n) {
    for(int i = 1; i < n; i++) {
        if(a * a + (a + i) * (a + i) == n) {
            return true;
        }
        a += i;
    }
    return false;
}
