/* challenge was ~~ https://codefights.com/challenge/X8MtaW3zRCTSkkCnA/solutions/LzSJY5GrCGNnaDh7L */
/* Power of BigInteger in Java */

int sum34(int n) {
    int s = 0;
    for(char c: BigInteger.valueOf(2).pow(n).toString().toCharArray())
        s += c-'0';
    return s;
}