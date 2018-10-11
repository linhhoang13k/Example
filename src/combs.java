/*combs.java
 *created by Ian Feekes January 8th 2017
 *Codefights
 *The Core
 *springOfIntegration
 *#91
 */

int combs(String comb1, String comb2){
    int n1 = comb1.Length, n2 = comb2.Length, result = n1 + n2;
    int m1 = mask(comb1), m2 = mask(comb2);
    for(int i = 0; i<=n1;i++) {
        if (((m2 << i) & m1) == 0) {
            int tmp = (int)Math.Max(n2 + i, n1);
            if (tmp < result) {
                result = tmp;
            }
        }
    }
    for( int i = 0;i<=n2;i++) {
        if (((m1 << i) & m2) == 0) {
            int tmp = (int)Math.Max(n1 + i, n2);
            if (tmp < result) {
                result = tmp;
            }
        }
    }
    return result;
}
 
int mask(String comb){
    int result = 0;
    foreach(char c in comb) {
        int digit = 0;
        if(c == '*') {
            digit = 1;
        }
        result = (result << 1) + digit;
    }
    return result;
}
