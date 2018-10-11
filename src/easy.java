// https://codefights.com/challenge/P9WCdK4fKeRxbiTiL/solutions/D2Byi3nZbWjPTsh54
boolean easy(int[] h) {
    boolean a=false; 
    int sum = 0;
        for (int e : h){
           sum += e; 
        } 
    if((sum%h.length)==0){
        a=!a;
    }
        return a;
}
