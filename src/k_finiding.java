// https://codefights.com/challenge/u6NWPj6qfgAQ572vJ/solutions/MaNri9EehnknWTDXb
int k_finiding(int[] a) {
    int k = 9;
    boolean c = true;
    int e = a.length - 1;
    while(c) {
        for(int j = 0, d = 0; j < e; j++) {
            if(a[j] % k != a[j + 1] % k)
                break;
            if(a[j] == a[j + 1])
                d++;
            if(j == e - 1)
                return k;
            if(d == e - 1)
                return -1;
        }
        k--;
    }
    return k;
}
