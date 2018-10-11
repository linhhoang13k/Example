int halvingSum(int n) {
    int sum = 0;
    for(int i = 1 ; i <= n ; i*=2){
        int div = (n / i);
        sum += div;
    }
    return sum;
}

/*
Given a positive integer n, calculate the following sum: n + n/2 + n/4 + n/8 + .... All divisions are integer.

For n = 25, the output should be
halvingSum(n) = 47.

The sum to be calculated is 25 + 12 + 6 + 3 + 1, which is 47.
*/
