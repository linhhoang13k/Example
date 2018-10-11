// https://codefights.com/challenge/HSqWTW4daxqPN68mh/solutions/tB5QsGN7YZqn2Gq7a
int[] SortByGuide(int[] a, int[] guide) {
    int[] b = new int[a.length];
    int c = 0;
    int e = 0;
    for(int i = 0; i < a.length; i++) {
        if(guide[i] > c) {
            c = guide[i];
        }
    }
    int[] d = new int[c];
    for(int i = 0; i < a.length; i++) {
        if(guide[i] != -1) {
            d[guide[i] - 1] = a[i];
        }
        else {
            b[i] = a[i];
        }
    }
    for(int i = 0; i < a.length; i++) {
        if(b[i] == 0) {
            b[i] = d[e];
            e++;
        }   
    }
    return b;
}
