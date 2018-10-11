int factorialsProductTrailingZeros(int l, int r) {
        int prod = 0;
        for(int i = l ; i <= r ; i++)  prod += ( i / 5 ) + ( i / 25 );
        return prod;
}

Another Solution :
int factorialsProductTrailingZeros(int l, int r) {
    int prod = 0;
      for (int i = l; i <= r; i++) {
             for (int j = 4; j <= i; j++) {
                   if ( j % 25 == 0) prod++;
                   if ( j % 5 == 0 ) prod++;
             }
      }
      return prod;
}

Another Solution :

int factorialsProductTrailingZeros(int l, int r) {
    int result = 0;
    for (int i = l; i <= r; i++) {
        int j = i, x =5;        
        while (j >= x){ 
            result += j / x;
            x *= 5;
        }
    }
    return result;
}
-----------------------------------------------------------------------
Task :

Given integers l and r, find the number of trailing zeros in the decimal representation of l! * (l + 1)! * ... * r! 
(the exclamation mark means factorial).

Example

For l = 4 and r = 10, the output should be
factorialsProductTrailingZeros(l, r) = 7.
