int DigitSumRange(int a, int b) {
    int x=0,s=0,i=a;
    while(i<=b){
        int j=i;
        while (j > 0) {
        s = s + j % 10;
        j /= 10;
        }
      x+=s;
      s=0;
      i++;
    }
    return x;
}
