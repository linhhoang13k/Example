int[] digitRootSort(int[] a) {
    int temp, b, dArr[] = new int[a.length];
    for(int i = 0; i < a.length; i++) {
        b = a[i];
        while(b > 0) {
            dArr[i] += b % 10;
            b /= 10;
        }
    }
    for(int j = 0; j < a.length - 1; j++) {
        for(int k = j + 1; k < a.length; k++) {
            if(dArr[j] > dArr[k] || dArr[j] == dArr[k] && a[j] > a[k]) {
                temp = a[j];
                a[j] = a[k];
                a[k] = temp;
                temp = dArr[j];
                dArr[j] = dArr[k];
                dArr[k] = temp;
            }
        }
    }
    return a;
}
