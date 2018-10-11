// https://codefights.com/challenge/zdgEWEruSgYQFqyM5/solutions/oTfF9yyGSjS2JenWq
int a;
int b;
String changeCase(String w) {
    for(int i = 0; i < w.length(); i++) {
        if(Character.isUpperCase(w.charAt(i)))
            a++;
        else
            b++;
    }
    if(a <= b)
        return w.toLowerCase();
    if(a > b)
        return w.toUpperCase();
    return w;
}
