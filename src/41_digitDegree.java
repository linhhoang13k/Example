/*
Let's define digit degree of some positive integer as the number of times we need to replace this number with the sum of its digits until we get to a one digit number.

Given an integer, find its digit degree.

Example

    For n = 5, the output should be
    digitDegree(n) = 0;
    For n = 100, the output should be
    digitDegree(n) = 1.
    1 + 0 + 0 = 1.
    For n = 91, the output should be
    digitDegree(n) = 2.
    9 + 1 = 10 -> 1 + 0 = 1.

Input/Output

    [execution time limit] 3 seconds (java)

    [input] integer n

    Guaranteed constraints:
    5 ≤ n ≤ 109.

    [output] integer
*/

int digitDegree(int n) {

    int number = n;
    int timesRequired = 0;
    while(number >= 10){
    	
        timesRequired++;
        int length = String.valueOf(n).length();
        int digitSum = 0;

        for(int index = 0; index < length; index++){
            digitSum += number % 10;
            number /= 10;
        }

        number = digitSum; 
    }

    return timesRequired;
}