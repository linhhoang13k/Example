int assignGroups(int[] t, int g) {
    Arrays.sort(t);
    int s = 0;
    for(int i = t.length - 1; i >= 0; i -= g)
        s += t[i];
    return s;
}
