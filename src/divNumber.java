int divNumber(int k, int l, int r) {
    int cnt = 0;
    for(int i = l ; i <= r ; i++){
        int nums = 0;
        for(int j = 1 ; j <= i ; j++){
            if(i % j == 0) nums++;
        }
        if(nums == k) cnt++;
    }
    return cnt;
}
/*
Given three integers k, l and r return the number of integers between l and r inclusive that have exactly k divisors.

It is guaranteed that l ≤ r.

For k = 3, l = 2 and r = 49, the output should be
divNumber(k, l, r) = 4.

We have 4 integers in that range that have exactly 3 divisors - 4, 9, 25, 49.
*/
