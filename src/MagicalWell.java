int magicalWell(int a, int b, int n) {
    int add = 0;
    for(int i = 0 ; i < n ; i++){
        add = add + (a*b);
        a++;
        b++;
    }
    return add;
}
