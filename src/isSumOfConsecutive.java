boolean isSumOfConsecutive(int n) {
    for (int last=1; last<n; last++){
            for (int first=0; first<last; first++){
                if (2*n == (last-first)*(last+first+1)) return true;     
            }
        }
    return false;
}

or 

boolean isSumOfConsecutive(int n) {
    if((n > 0) && ((n & (n - 1)) == 0)) return false;
    return true;   
}
