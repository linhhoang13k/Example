/*
Given an integer n, your task is to calculate the sum of digits in n! and return the answer modulo 9.

Example

For n = 4, the output should be
digitSumFactorial(n) = 24.

n! = 24, the sum of digits is 2 + 4 = 6, and 6 % 9 = 6. Thus, the output should be 6.
*/

int digitSumFactorial(int n) {
    int f=1,d=0;
    for(int i=1; i<= n; i++)
        f = f*i;
    while (f > 0) {
            d = d + f%10;
            f /= 10;
        }
    return d%9;
}
