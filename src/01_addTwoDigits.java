/*
You are given a two-digit integer n. Return the sum of its digits.

Example

For n = 29, the output should be
addTwoDigits(n) = 11.

Input/Output

    [execution time limit] 3 seconds (java)

    [input] integer n

    A positive two-digit integer.

    Guaranteed constraints:
    10 ≤ n ≤ 99.

    [output] integer

    The sum of the first and second digits of the input number.
*/

int addTwoDigits(int n) {
    int number = n;
    int secondDigit = number % 10;
    int firstDigit = number / 10;
    return firstDigit + secondDigit;
}