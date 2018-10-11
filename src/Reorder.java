// https://codefights.com/challenge/ZRYQizmBhwb6S4iKx/solutions/ar8ezhpB5o6wvArCe
String Reorder(int n, String w) {
    int b = w.length();
    if(n > b)
        n = n % b;
    String a = w.substring(n,b);
    a += w.substring(0,n);
    if(n == b)
        a = w;
    return a;
}
