int[] arrayPreviousLess(int[] items) {
    int[] a = new int[items.length];
    Arrays.fill(a , -1);
    a[0] = -1;
    for(int i = 1 ; i < a.length ; i++){
        for(int j = i - 1 ; j >= 0 ; j--){
            if(items[j] < items[i]){
                a[i] = items[j];
                break;
            }
        }
    }
    return a;
}
