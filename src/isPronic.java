// https://codefights.com/challenge/qZfpoeALnuY26YNaf/solutions/drdianuibef6AjCDk
boolean isPronic(int n) {
    for(int i = -1; i < n; i++) {
        if(i *(i + 1) == n) {
            return true;
        }
    }
    return false;
}
