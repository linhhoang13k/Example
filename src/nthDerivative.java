int M = 1000000007;
int nthDerivative(int[] c, int n, int x) {
    long a = 0;
    
    for(int i = n; i < c.length; i++) 
        a += (c[i]*Math.pow(x,i-n)*f(i)/f(i-n)); 
    return (int)((a % M) + M) % M;
}

//BigInteger fact(int k) {
//    BigInteger b = new BigInteger("1");
//   for(int j = 2; j <= k; j++)
//        b = b.multiply(BigInteger.valueOf(j));
//    return b;
//}

long f(int k){
    return k<=1?1:(k*f(k-1))%M;
}
