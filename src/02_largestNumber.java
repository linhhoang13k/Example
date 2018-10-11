/*
Given an integer n, return the largest number that contains exactly n digits.

Example

For n = 2, the output should be
largestNumber(n) = 99.

Input/Output

    [execution time limit] 3 seconds (java)

    [input] integer n

    Guaranteed constraints:
    1 ≤ n ≤ 9.

    [output] integer

    The largest integer of length n.
*/

int largestNumber(int n) {
    StringBuilder builderString = new StringBuilder();
    for(int i = 0; i < n ; i++){
        builderString.append("9");
    }
    int largestNumber = Integer.parseInt(builderString.toString());
    return largestNumber;
}