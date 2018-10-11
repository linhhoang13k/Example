// https://codefights.com/challenge/QczEop25GyKxsRTjJ/solutions/TzL87xFLZnbjmdQBn
int a;
int[] FibonacciSort(int[] s) {
    int x = s.length;
    int[] f = new int[x];
    f[0] = 0;
    f[1] = 1;
    f[2] = 2;
    for(int i = 3; i < x; i++)
        f[i] += f[i - 1] + f[i - 2];
    List<Integer> n = new ArrayList<Integer>();
    for(int i = 0; i < x; i++) {
        if(i == f[a]) {
            n.add(s[i]);
            a++;
        }
    }
    Collections.sort(n);
    a = 0;
    for(int i = 0; i < x; i++) {
        if(i == f[a]) {
            s[i] = n.get(a);
            a++;
        }
    }
    return s;
}
