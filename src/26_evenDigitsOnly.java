/*
Check if all digits of the given integer are even.

Example

    For n = 248622, the output should be
    evenDigitsOnly(n) = true;
    For n = 642386, the output should be
    evenDigitsOnly(n) = false.

Input/Output

    [execution time limit] 3 seconds (java)

    [input] integer n

    Guaranteed constraints:
    1 ≤ n ≤ 109.

    [output] boolean

    true if all digits of n are even, false otherwise.
*/

boolean evenDigitsOnly(int n) {
    String  stringVersion = Integer.toString(n);
    int numberLength = stringVersion.length();
    int number = n;
    boolean evenDigitsOnly = true;

    for(int digit = 0; digit < numberLength; digit++){
        if(number % 2 != 0){
            evenDigitsOnly = false;
        }
        number = number / 10;
    }

    return evenDigitsOnly;
}
