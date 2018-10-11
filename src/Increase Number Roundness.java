boolean increaseNumberRoundness(int n) {
    
    while (n > 0) {
        int rem = n%10;
        n /= 10;
        if (rem != 0) {
            break;
        }   
    }
    
    while (n > 0) {
        if (n % 10 == 0) {
            return true;
        }

        n /= 10;
    }
        
    return false;
}
