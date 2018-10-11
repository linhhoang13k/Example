/*
Given some integer, find the maximal number you can obtain by deleting exactly one digit of the given number.

Example

    For n = 152, the output should be
    deleteDigit(n) = 52;
    For n = 1001, the output should be
    deleteDigit(n) = 101.

Input/Output

    [execution time limit] 3 seconds (java)

    [input] integer n

    Guaranteed constraints:
    10 ≤ n ≤ 106.

    [output] integer
*/

int deleteDigit(int n) {
    String digitString = Integer.toString(n);
    int digitLength = digitString.length();
    int maxValue = 0;
    
    for(int i = 0; i < digitLength; i++){
        int value = Integer.parseInt(digitString.substring(0,i)+digitString.substring(i+1));
        if(value > maxValue){
            maxValue = value;
        }
    }
    return maxValue;
}
