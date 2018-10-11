int countWaysToChangeDigit(int value) {
    int res = 0;
    while (value > 0) {
            res += 9 - value % 10;
            value /= 10;
    }
    return res;
}

/*
Given an integer, find the number of the ways to change exactly one digit in it in order to obtain a bigger integer.

For value = 10, the output should be
countWaysToChangeDigit(value) = 17.
*/
