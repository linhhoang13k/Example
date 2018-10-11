/*
Pi

Your task is to return a string consisting of digits of p from the frth to the toth one, inclusive.

Example

For fr = 1 and to = 8, the output should be
pi(fr, to) = "14159265".
*/

String piRange(int f, int t) {

     String x="";
     int S = 10000,A=2000,d = 20000,c = 0;

        StringBuffer p = new StringBuffer();  
        int[] a = new int[d + 1];  
    
        for (int i = 0; i <= d; ++i)  
            a[i] = A;  
  
        for (int i = d; i > 0; i-= 14) {  
            int s = 0;  
            for (int j = i; j > 0; --j) {  
                s = s * j + S * a[j];  
                a[j] = s % (j * 2 - 1);  
                s /= j * 2 - 1;  
            }  
         p.append(String.format("%04d", c + s / S));  
         c = s % S;  
        }  
         for(int i=f; i<=t; i++)
            x += p.charAt(i);
    
    
    return x;
}

