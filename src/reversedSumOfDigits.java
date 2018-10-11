String reversedSumOfDigits(int p, int n) {
    
    if( (p == 0 && n == 1)) return "0";
    if(9 * n < p || p == 0  ) return "-1";
    
    String result = "";
    for (int i = 0; i < n-1; i++){
        int tmp = (p - 1) > 9 ? 9: (p - 1);
        p -= tmp;
        result = tmp + result;
    }   
    return p + "" + result;
}

/*
Given integers p and n, find the smallest non-negative n-digit integer (represented as a string) whose digits add up to p. 
If there is no such number, return "-1" instead.

For p = 15 and n = 3, the output should be
reversedSumOfDigits(p, n) = "159";

For p = 30 and n = 2, the output should be
reversedSumOfDigits(p, n) = "-1";

For p = 2 and n = 5, the output should be
reversedSumOfDigits(p, n) = "10001".
*/
