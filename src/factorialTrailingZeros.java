int factorialTrailingZeros(int n) {
    int sum = 0;
    while(n){
        sum += n / 5;
        n /= 5;
    }
    return sum;    
}

/*
Given an integer n, find the number of trailing zeros in the decimal representation of n! (the exclamation mark means factorial).

Note : n! is the factorial of n defined as the product of all positive integers less than or equal to n. 
For convenience 0! is defined to be equal to 1.

For n = 10, the output should be
factorialTrailingZeros(n) = 2.
10! = 3628800, it has 2 trailing zeros.
*/
