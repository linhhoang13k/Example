int sumBelowBound(int bound) {
    int sum = 0, i = 0;
    while(sum <= bound) sum += ++i;
    return i-1;
}

/*
Given an integer bound, find the maximal integer n such that 1 + 2 + ... + n ≤ bound.

For bound = 14, the output should be
sumBelowBound(bound) = 4
*/
