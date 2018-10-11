// https://codefights.com/challenge/EgrgxeZ9bui4noqP2/solutions/7DLgy6q7sotDn2S9Z
int b;
int c;
String order(int[] a) {
    int d = a.length - 1;
    for(int i = 0; i < d; i++) {
        if(a[i] < a[i + 1]) {
            b++;
        }
        if(a[i] > a[i + 1]) {
            c++;
        }
        if(b == d) {
            return "ascending";
        }
        if(c == d) {
            return "descending";
        }
    }
    return "not sorted";
}
