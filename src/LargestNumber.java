/* 
* Challenge Name: Largest Number
* Given an integer n, return the largest number that contains exactly n digits.
*
*  Example: For n = 2, the output should be largestNumber(n) = 99.
*/


int largestNumber(int n) {
    if (n == 1) {
        return 9;
    } else if (n == 2) {
        return 99;
    } else if (n == 3) {
        return 999;
    } else if (n == 4) {
        return 9999;
    } else if (n == 5) {
        return 99999;
    } else if (n == 6) {
        return 999999;
    } else if (n == 7) {
        return 9999999;
    }
    return 0;
}