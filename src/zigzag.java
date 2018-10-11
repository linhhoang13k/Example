int zigzag(int[] a) {
    int max = 1, maxSlice = 1;
    for(int i = 1; i < a.length - 1; i++) {
        max = (a[i] > a[i - 1] && a[i] > a[i + 1]) || (a[i] < a[i - 1] && a[i] < a[i + 1])?max + 1:2;
        maxSlice = Math.max(max, maxSlice);
    }
    return maxSlice;
}
