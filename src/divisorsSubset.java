int divisorsSubset(int[] subset, int n) {
    int res =0;
    for(int i = 1 ; i <= n ; ++i){
        boolean check = true;
        for(int d : subset) if(i % d != 0) check = false;
        if(check) ++res;
    }
    return res ;
}

/*
Given an array of integers subset and an integer n, find the number of integers between 1 and n, 
inclusive, whose set of divisors contains subset as a subset.
Example
For subset = [2, 3] and n = 13, the output should be
divisorsSubset(subset, n) = 2.
These integers are 6 and 12.
*/
