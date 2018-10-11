int[] switchLights(int[] a) {
    for(int i = 1 ; i <= a.length ; i++){
        if(a[i - 1] == 0)
            continue;
        for(int j = 0 ; j < i ; j++){
            if(a[j] == 1){
                a[j] = 0;
                continue;
            }
            if(a[j] == 0)
                a[j] = 1;
        }
    }
    return a;
}
