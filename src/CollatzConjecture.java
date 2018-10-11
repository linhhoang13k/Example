// https://codefights.com/challenge/6SCFDgthRTX3vsRPC/solutions/JyYYbGkbiJSBaQ6vh
String CollatzConjecture(int n) {
    String a = String.valueOf(n);
    while(n > 2) {
        if(n % 2 == 0) {
            n /= 2;
        }
        else {
            n = n * 3 + 1;
        }
        a += " " + String.valueOf(n);
    }
    if(n > 1) {
        return a;
    }
    return "";
}
