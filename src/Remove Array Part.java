int[] removeArrayPart(int[] inputArray, int l, int r) {
    int[] ans = new int[inputArray.length - (r-l+1)];
    int j = 0;
    
    for (int i=0;i<inputArray.length;i++) {
        if (i < l || i > r) {
            ans[j++] = inputArray[i];
        }
    }
    
    return ans;
}
