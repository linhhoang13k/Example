int[] sortByHeight(int[] a) {
    int[] res = new int[a.length];
    int i = 0;
    for(int n : a){
        if(n != -1){
            res[i] = n;
            i++;
        }
    }
    i = a.length - i;
    Arrays.sort(res);
    
    for(int j = 0; j < a.length; j++){
        if(a[j] != -1){
            a[j] = res[i];
            i++;
        }
    }
    return a;
}
