// https://codefights.com/challenge/sMP85aZRQeFfjHDR4/solutions/xkMQbiGqpNA3eZ87s
String[] printPyramid(int c, boolean d) {
    String[] a = new String[c];
    for(int i = 1; i <= c; i++) {
        a[i-1] = "";
        if(d)
            for(int j = 0; j < i; j++)
                a[i-1] += "*";
        else
            for(int j = 0; j < c - i + 1; j++)
                a[i-1] += "*";
    }
    return a;
}
