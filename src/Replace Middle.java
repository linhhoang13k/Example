int[] replaceMiddle(int[] arr) {
    
    if (arr.length%2 != 0) return arr;
    
    int middle = arr[arr.length/2 - 1] + arr[arr.length/2];
    int[] ans = new int[arr.length-1];
    int j = 0;
    
    for (int i=0;i<arr.length;i++) {
        if (i == arr.length/2 - 1) {
            ans[j++] = middle;  
        }
        else if (i != arr.length/2) {
            ans[j++] = arr[i];
        }
    }
    
    return ans;
}
