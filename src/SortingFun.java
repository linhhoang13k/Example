// https://codefights.com/challenge/2u95D9aR3dFgEH6Pc/solutions/mT4SE2stTtPHeCihy
String[] SortingFun(String[] g) {
    int z = g.length;
    int[] a = new int[z];
    String[] b = new String[z];
    HashMap<Integer, String> m = new HashMap<>();
    for(int i = 0; i < z; i++) {
        for(int j = 0; j < g[i].length(); j++) {
            int y = (int) g[i].charAt(j);
            a[i] += y - 97;
        }
        
        m.put(a[i], g[i]);
    }
    Arrays.sort(a);
    for(int i = 0; i < z; i++) {
        b[i] = m.get(a[i]);
    }
    return b;
}
