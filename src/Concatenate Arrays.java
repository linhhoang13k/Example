int[] concatenateArrays(int[] a, int[] b) {
    int[] ans = new int[a.length + b.length];
    int j = 0;
    
    for (int i=0;i<a.length;i++) {
        ans[j++] = a[i];
    }
    
    for (int i=0;i<b.length;i++) {
        ans[j++] = b[i];
    }
    
    return ans;
}
