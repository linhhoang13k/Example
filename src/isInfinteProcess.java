boolean isInfiniteProcess(int a, int b) {
    while(a<=b){
        if(a==b){
            return false;
        }
        a++;
        b--;
    }
    return true;
}
