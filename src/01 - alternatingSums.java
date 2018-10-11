int[] alternatingSums(int[] a) {
    int[] sums = {0, 0};
    for(int i = 0; i < a.length; i++){
        if(i % 2 == 0) 
            sums[0] += a[i];
        else 
            sums[1] += a[i];
    }
    return sums;
}
