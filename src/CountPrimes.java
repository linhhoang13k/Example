class CountPrimes {
    public int countPrimes(int n) {
       int count = 0;
        for(int i=1; i<n; i++){
            if(isPrime(i)){
                
                count++;
            }
        }
        return count;
    }
    
    boolean isPrime(int num){
        if ( num > 2 && num%2 == 0 || num==1) {
        return false;
    }
    int top = (int)Math.sqrt(num) + 1;
    for(int i = 3; i < top; i+=2){
        if(num % i == 0){
            return false;
        }
    }
    return true;
    }
}