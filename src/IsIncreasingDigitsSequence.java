boolean isIncreasingDigitsSequence(int n) {

    if(n<10)
        return true;
    int x=n%10;
    n/=10;
    while(n>0)
    {
        int y=n%10;
        if(y>=x)
            return false;
        x=y;
        n/=10;
    }
    return true;
}
