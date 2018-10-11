int maxMultiple(int divisor, int bound) {
    
    int ans = 0;
    
    while(bound > 0) {
        if (bound%divisor == 0) {
            ans = bound;
            break;
        }
        bound--;
    }
    
    return ans;
}
