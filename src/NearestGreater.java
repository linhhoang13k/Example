int[] nearestGreater(int[] a) {
   
    int [] b = new int[a.length];
    boolean foundGreater = false;
    boolean leftFound = false;
    
    for(int i = 0; i < a.length; i++) {
        int up = 1;
        int down = 1;
        foundGreater = false;
        leftFound = false;
        
        while(foundGreater == false) {
            if(i-down >= 0) {
                if(a[i-down] > a[i]) {
                    foundGreater = true;
                    leftFound = true;
                    b[i] = i-down;
                }
            }
            if (i+up < a.length && leftFound == false) {
                if(a[i+up] > a[i]) {
                    foundGreater = true;
                    b[i] = i + up;
                }
                
            }
            if(i-down < 0 && i+up >= a.length) { 
                foundGreater = true;
                b[i] = -1;
            }
            
            up++;
            down++;
            
        }
    }
    
    return b;
}
